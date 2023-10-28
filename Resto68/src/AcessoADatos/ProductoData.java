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
        String sql = "INSERT INTO producto (nombreProducto, tipoProducto, stock, precio, estado)VALUES(?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getTipoDeProducto());
            ps.setInt(3, producto.getStock());
            ps.setDouble(4, producto.getPrecio());
             if (producto.getStock() == 0) {
                ps.setBoolean(5, false);
            } else {
                ps.setBoolean(5, producto.isEstado());
            }
//            ps.setBoolean(5, producto.isEstado());
            

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
        String sql = "UPDATE producto SET nombreProducto=?, tipoProducto=?, stock=?, precio=?, estado=? WHERE IdProducto=? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getTipoDeProducto());
            ps.setInt(3, producto.getStock());
            ps.setDouble(4, producto.getPrecio());
            if (producto.getStock() == 0) {
                ps.setBoolean(5, false);
            } else {
                ps.setBoolean(5, producto.isEstado());
            }
            ps.setInt(6, producto.getIdProducto());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Producto modificado :D");
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
        String sql = "SELECT tipoProducto, nombreProducto, stock, precio, estado FROM producto WHERE idProducto = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(idProducto);
                producto.setTipoDeProducto(rs.getString("tipoProducto"));
                producto.setNombre(rs.getString("nombreProducto"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getDouble("precio"));
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

    public List<Producto> buscarProductoPorTipo(String tipoDeProducto) {
        //AGREGAR LISTA
        List<Producto> listaProductos = new ArrayList<>();
        for (Producto productos : this.listarProductos())//acá uso el método de listar productos que hice más abajo
        {
            if (tipoDeProducto.equals(productos.getTipoDeProducto())) {
                listaProductos.add(productos);
            }
        }
        return listaProductos;
    }

    public Producto buscarProductoPorNombre(String nombre) {
     //   List<Producto> listaProductos = new ArrayList<>();
       Producto producto = null;
        String sql = "SELECT idProducto, tipoProducto, stock, precio, estado FROM producto WHERE nombreProducto=?";
        PreparedStatement ps = null;
         try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setTipoDeProducto(rs.getString("tipoProducto"));
                producto.setNombre(nombre);
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getDouble("precio"));
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

    public List<Producto> buscarProductoPorEstado(boolean estado) {
        List<Producto> listaProductos = new ArrayList<>();
        for (Producto productos : this.listarProductos())//acá uso el método de listar productos que hice más abajo
        {
            if (productos.isEstado() == estado) {
                listaProductos.add(productos);
            }
        }
        return listaProductos;
    }

    public List<Producto> buscarProductosMenorAMayorPrecio() {
        List<Producto> listaProductos = new ArrayList<>();

        String sql = "SELECT * FROM producto";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();

                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombreProducto"));
                producto.setTipoDeProducto(rs.getString("tipoProducto"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setEstado(rs.getBoolean("estado")); //REVISAR SI SE PUEDE HACER ASÍ
                System.out.println(".");
                listaProductos.add(producto);
            }

            rs.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ProductoData1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo ingresar a la tabla");
        }
        // Ordena la lista de productos por precio ascendente
        Collections.sort(listaProductos, comparaPrecio);//ORDENA
        return listaProductos;
    }

    public List<Producto> buscarProductosMayorAMenorPrecio() {
        List<Producto> listaProductos = new ArrayList<>();

        String sql = "SELECT * FROM producto";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();

                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombreProducto"));
                producto.setTipoDeProducto(rs.getString("tipoProducto"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setEstado(rs.getBoolean("estado")); //REVISAR SI SE PUEDE HACER ASÍ
                System.out.println(".");
                listaProductos.add(producto);
            }

            rs.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ProductoData1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo ingresar a la tabla");
        }
        // Ordena la lista de productos por precio ascendente
        Collections.sort(listaProductos, comparaPrecioMayorAMenor);//ORDENA
        return listaProductos;
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
                producto.setNombre(rs.getString("nombreProducto"));
                producto.setTipoDeProducto(rs.getString("tipoProducto"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getDouble("precio"));
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

    public static Comparator<Producto> comparaNombre = new Comparator<Producto>() { //SUBCLASE. Lo que está entre <> es el tipo.
        @Override
        public int compare(Producto p1, Producto p2) {
            return p1.getNombre().compareTo(p2.getNombre()); //compara el nmbre de un producto con el otro.
        }
    };
    public static Comparator<Producto> comparaPrecio = new Comparator<Producto>() { //SUBCLASE. Lo que está entre <> es el tipo.
        @Override
        public int compare(Producto p1, Producto p2) {
            return Double.compare(p1.getPrecio(), p2.getPrecio());//compara el precio de un producto con el otro.
        }
    };
    public static Comparator<Producto> comparaPrecioMayorAMenor = new Comparator<Producto>() { //SUBCLASE. Lo que está entre <> es el tipo.
        @Override
        public int compare(Producto p1, Producto p2) {
            return Double.compare(p2.getPrecio(), p1.getPrecio());//compara el precio de un producto con el otro.
        }
    };
}
