/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AcessoADatos;

import Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Zona
 */
public class ProductoData {

    private Connection con = null;

    public ProductoData() {
        con = Conexion.getConexion();
    }

    public void agregarProducto(Producto producto) {
        String sql = "INSERT INTO producto (Nombre, TipoProducto, Stock, Precio, Estado)VALUES(?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getTipoDeProducto());
            ps.setInt(3, producto.getStock());
            ps.setInt(4, producto.getPrecio());
            ps.setBoolean(5, producto.isEstado());

            List<Producto> listaProductos = new ArrayList<>();
            listaProductos = this.listarProductos();

            boolean bandera = false;
            for (Producto listaProducto : listaProductos) {
                if (producto.getNombre().equals(listaProducto.getNombre())) {//comparo el nombre que agregamos y el nombre de mi lista
                    bandera = true;
                }
            }

            if (!bandera) {
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
                }

            } else {
                JOptionPane.showMessageDialog(null, "El prodcuto agregado ya existe.");
            }
            ps.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto." + ex.getMessage());

        }

    }

    public void modificarProducto(Producto producto) {
        String sql = "UPDATE producto SET nombre=?, tipoProducto=?, stock=?, precio=?, estado=? WHERE IdProducto=? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getTipoDeProducto());
            ps.setInt(3, producto.getStock());
            ps.setInt(4, producto.getPrecio());
            ps.setBoolean(5, producto.isEstado());
            ps.setInt(6, producto.getIdProducto());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Producto modificado");
            }

        } catch (SQLException ex) {
            //Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto" + ex.getMessage());

        }
    }

    public void eliminarProducto(int id) {
        String sql = "UPDATE producto SET estado=0 WHERE idProducto = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Producto eliminado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto");
        }

    }

    public Producto buscarProducto(int idProducto) {
        Producto producto = null;
        String sql = "SELECT tipoDeProducto, nombre, stock, precio, estado FROM producto WHERE idProducto = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(idProducto);
                producto.setTipoDeProducto(rs.getString("tipoDeProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe el producto buscado");
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla" + ex.getMessage());

        }

        return producto;

    }
    public Producto buscarProductoPorTipo(String tipoDeProducto) {
        Producto producto = null;
        String sql = "SELECT idProducto, nombre, stock, precio, estado FROM producto WHERE tipoDeProducto = ?";
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoDeProducto);
            ResultSet rs= ps.executeQuery();
            
            if(rs.next()){
                producto = new Producto();
                producto.setTipoDeProducto(tipoDeProducto);
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setEstado(rs.getBoolean("estado")); //REVISAR SI SE PUEDE HACER ASÍ
            }else{
                JOptionPane.showMessageDialog(null, "No existe este producto en la tabla");
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo ingresar a la tabla");
        }
        
        return producto;

    }
    
    public List<Producto> listarProductos() {
        List<Producto> productoList = new ArrayList<>();

        String sql = "SELECT * FROM producto";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setTipoDeProducto(rs.getString("tipoProducto"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setEstado(rs.getBoolean("estado"));
                productoList.add(producto);
            }
            ps.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ProductoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla" + ex.getMessage());
        }

        return productoList;
    }

    
    public List<Producto> buscarProductosMenorAMayorPrecio(int precio){
        List<Producto> listaProductos = new ArrayList<>();
        
        String sql = "SELECT idProducto, nombre, stock, estado FROM producto ORDER BY precio ASC LIMIT 1";//para ordenar de menor a mayor precio
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, precio);
            ResultSet rs= ps.executeQuery();
                        
            if(rs.next()){
               Producto producto = new Producto();
                producto.setPrecio(precio);
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getInt("precio"));
                producto.setEstado(rs.getBoolean("estado")); //REVISAR SI SE PUEDE HACER ASÍ
                listaProductos.add(producto);
            }else{
                JOptionPane.showMessageDialog(null, "No existe este producto en la tabla");
            }
            rs.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ProductoData1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo ingresar a la tabla");
        } 
        // Ordena la lista de productos por precio ascendente
    Collections.sort(listaProductos, (p1, p2) -> Integer.compare(p1.getPrecio(), p2.getPrecio()));
        return listaProductos;
    }

   public static Comparator<Producto> comparaNombre = new Comparator<Producto>() { //SUBCLASE. Lo que está entre <> es el tipo.
        @Override
        public int compare(Producto p1, Producto p2) {
            return p1.getNombre().compareTo(p2.getNombre()); //compara el nmbre de un producto con el otro.
        }
    };
   //    public ClaseProducto buscarProductoConPrecioMenorA2000(int precio){//quise hacer yo
//        //List<ClaseProducto> listarProductosPorPrecio = new ArrayList<>();
//        String sql = "SELECT idProducto, nombre, stock, estado FROM producto WHERE precio = ?";
//        
//        PreparedStatement ps;
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, precio);
//            ResultSet rs= ps.executeQuery();
//            ClaseProducto producto = new ClaseProducto();
//            if(rs.next()){
//                
//                if(precio>=0 && precio<=2000){
//                
//                producto.setPrecio(precio);
//                producto.setIdProducto(rs.getInt("idProducto"));
//                producto.setNombre(rs.getString("nombre"));
//                producto.setStock(rs.getInt("stock"));
//                producto.setPrecio(rs.getInt("precio"));
//                producto.setEstado(rs.getBoolean("estado"));
//                
//                }
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductoData1.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
            
        
    }
    /*
    public ClaseProducto buscarProductoConPrecioMenorA2000() {//me lo corrigio chatgpt
    ClaseProducto producto = null;
    String sql = "SELECT idProducto, nombre, stock, precio, estado FROM producto WHERE precio <= 2000 ORDER BY precio ASC LIMIT 1";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            producto = new ClaseProducto();
            producto.setIdProducto(rs.getInt("idProducto"));
            producto.setNombre(rs.getString("nombre"));
            producto.setStock(rs.getInt("stock"));
            producto.setPrecio(rs.getInt("precio"));
            producto.setEstado(rs.getBoolean("estado"));
        } else {
            // Puedes manejar el caso en el que no se encuentren productos con precio menor a 2000 aquí.
        }

        rs.close();
    } catch (SQLException ex) {
        // Maneja la SQLException según tus necesidades.
        Logger.getLogger(ProductoData1.class.getName()).log(Level.SEVERE, null, ex);
    }

    return producto;
}
    */

