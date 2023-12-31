/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AcessoADatos;

import Entidades.Pedido;
import Entidades.PedidoProducto;
import Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Fran-PC
 */
public class PedidoProductoData {

    private Connection con = null;
    ProductoData productoData = new ProductoData();
    PedidoData pedidoData = new PedidoData();

    public PedidoProductoData() {
        con = Conexion.getConexion();

    }

    public void crearCarrito(PedidoProducto pedprod) { // ALTA de pedidosProductos    (FALTA)          
        List<Pedido> pedList = new ArrayList();
        pedList = pedidoData.listarPedidosPorCobrada(false); //recibe los id de los pedidos no cobrados?, 
        List<Producto> prodList = new ArrayList();
        prodList = productoData.buscarProductoPorEstado(true); //devuelve lista de productos con stock
        List<PedidoProducto> pedprodList = new ArrayList();
        pedprodList = this.obtenerCarrito();
        boolean bandera = true;
        boolean bandera2 = false;

        String sql = "INSERT INTO pedidoproducto (idPedido, idProducto, cantidad) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedprod.getIdPedido());
            ps.setInt(2, pedprod.getIdProducto());
            ps.setInt(3, pedprod.getCantidad());

            for (Pedido listaPed : pedList) {
                if (listaPed.getIdPedido() == pedprod.getIdPedido()) { // verificacio
                    bandera = false; //si el pedido está cobrado y coincide con el idped que recibimos no debe poder cargar
                    // JOptionPane.showMessageDialog(null, "Puede agregar un nuevo pedido");

                }
            }
            for (Producto listaProd : prodList) {
                if (listaProd.getIdProducto() == pedprod.getIdProducto()) {
                    bandera2 = true;//{ si el producto tiene stock(está activo) y coincide con el idprod que intentamos agregar, debe poder cargar

                }
            }
            if (!bandera2) { //si es false no contamos con el producto 
                JOptionPane.showMessageDialog(null, "No contamos con ese producto");
            }
            if (!bandera && bandera2) {
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    pedprod.setIdPedidoProducto(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "agregado correctamente");
                    Producto prod = productoData.buscarProducto(pedprod.getIdProducto());
                    prod.setStock(prod.getStock() - pedprod.getCantidad());//hace que se le reste al stock que hay de prodcutos, la cantidad de productos ue usamos acá.
                    productoData.modificarProductoSin(prod);

                } else {
                    JOptionPane.showMessageDialog(null, "algo está mal, fijate");
                }
            } else {
                JOptionPane.showMessageDialog(null, "mmmm algo está mal, fijate");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se puede ingresar a la tabla pedidoProducto u.u" + ex.getMessage());
        }
    }

    public List<PedidoProducto> obtenerCarrito() { // METODO BUSCAR  OK
        List<PedidoProducto> listaPedProd = new ArrayList<>();
        String sql = "SELECT * FROM pedidoproducto";
        PedidoProducto pedProd = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pedProd = new PedidoProducto();
                pedProd.setIdPedidoProducto(rs.getInt("idPedidoProducto"));
                pedProd.setIdPedido(rs.getInt("idPedido"));
                pedProd.setIdProducto(rs.getInt("idProducto"));
                pedProd.setCantidad(rs.getInt("cantidad"));

                listaPedProd.add(pedProd);
            }
            ps.close();
        } catch (SQLException ex) {
            // Logger.getLogger(PedidoProductoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no se puede ingresar a la tabla pedidoProducto u.u" + ex.getMessage());

        }
        return listaPedProd;
    }

    public List<PedidoProducto> obtenerCarritoXidPedProd(int idPedProd) {
        List<PedidoProducto> listaPedProd = new ArrayList<>();
        String sql = "SELECT * FROM pedidoproducto where idPedidoProducto=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPedProd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PedidoProducto pedidoProducto = new PedidoProducto();
                pedidoProducto.setIdPedidoProducto(idPedProd);
                pedidoProducto.setIdPedido(rs.getInt("idPedido"));
                pedidoProducto.setIdProducto(rs.getInt("idProducto"));
                pedidoProducto.setCantidad(rs.getInt("cantidad"));
                listaPedProd.add(pedidoProducto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaPedProd;
    }

    public List<PedidoProducto> buscarXPedido(int idPedido) {
        List<PedidoProducto> listaPedProd = new ArrayList<>();
        String sql = "SELECT * FROM pedidoproducto where idPedido=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PedidoProducto pedidoProducto = new PedidoProducto();
                pedidoProducto.setIdPedidoProducto(rs.getInt("idPedidoProducto"));
                pedidoProducto.setIdPedido(idPedido);
                pedidoProducto.setIdProducto(rs.getInt("idProducto"));
                pedidoProducto.setCantidad(rs.getInt("cantidad"));
                listaPedProd.add(pedidoProducto);

            }
            ps.close();
        } catch (SQLException ex) {
            // Logger.getLogger(PedidoProductoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no se puede ingresar a la tabla pedidoProducto u.u" + ex.getMessage());

        }

        return listaPedProd;
    }

    public List<PedidoProducto> buscarXProducto(int idProducto) {
        List<PedidoProducto> listaProd = new ArrayList<>();
        String sql = "SELECT * FROM pedidoproducto where idProducto=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PedidoProducto pedidoProducto = new PedidoProducto();
                pedidoProducto.setIdPedidoProducto(rs.getInt("idPedidoProducto"));
                pedidoProducto.setIdPedido(rs.getInt("idPedido"));
                pedidoProducto.setIdProducto(idProducto);
                pedidoProducto.setCantidad(rs.getInt("cantidad"));
                listaProd.add(pedidoProducto);

            }
            ps.close();
        } catch (SQLException ex) {
            // Logger.getLogger(PedidoProductoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no se puede ingresar a la tabla pedidoProducto u.u" + ex.getMessage());

        }

        return listaProd;
    }

    public List<PedidoProducto> buscarXProductoYPedido(int idProducto, int idPedido) { //VER
        List<PedidoProducto> listaProd = new ArrayList<>();
        String sql = "SELECT * FROM pedidoproducto where idProducto=? and idPedido=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ps.setInt(2, idPedido);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PedidoProducto pedidoProducto = new PedidoProducto();
                pedidoProducto.setIdPedidoProducto(rs.getInt("idPedidoProducto"));
                pedidoProducto.setIdPedido(idPedido);
                pedidoProducto.setIdProducto(idProducto);
                pedidoProducto.setCantidad(rs.getInt("cantidad"));
                listaProd.add(pedidoProducto);

            }
            ps.close();
        } catch (SQLException ex) {
            // Logger.getLogger(PedidoProductoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no se puede ingresar a la tabla pedidoProducto u.u" + ex.getMessage());

        }

        return listaProd;
    }

    public List<PedidoProducto> buscarXCantidad(int cantidad) {
        List<PedidoProducto> listaCantidad = new ArrayList<>();
        String sql = "SELECT * FROM pedidoproducto where cantidad=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PedidoProducto pedidoProducto = new PedidoProducto();
                pedidoProducto.setIdPedidoProducto(rs.getInt("idPedidoProducto"));
                pedidoProducto.setIdPedido(rs.getInt("idPedido"));
                pedidoProducto.setIdProducto(rs.getInt("idProducto"));
                pedidoProducto.setCantidad(cantidad);
                listaCantidad.add(pedidoProducto);

            }
            ps.close();
        } catch (SQLException ex) {
            // Logger.getLogger(PedidoProductoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no se puede ingresar a la tabla pedidoProducto u.u" + ex.getMessage());

        }

        return listaCantidad;
    }

    public List<PedidoProducto> obtenerCarritoXPedido(int idPedido) { // metodo para devolver info desde la tabla PEDIDOPRDUCTO buscando por idPedido OK
        List<PedidoProducto> pedProdList = new ArrayList<>();

        String sql = "Select * FROM pedidoProducto where idPedido=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido); // le paso el id con el que vamos a buscar en las listas o tablas
            ResultSet rs = ps.executeQuery(); //traigo info de la tabla
            while (rs.next()) {
                PedidoProducto pedProd = new PedidoProducto();
                pedProd.setIdPedido(idPedido);
                pedProd.setIdPedidoProducto(rs.getInt("idPedidoProducto"));
                pedProd.setIdProducto(rs.getInt("idProducto"));
                pedProd.setCantidad(rs.getInt("cantidad"));
                pedProdList.add(pedProd);

            }
        } catch (SQLException ex) {
            //Logger.getLogger(PedidoProductoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " no es posible ingresar a la tabla pedidoProducto" + ex.getMessage());
        }
        return pedProdList;

    }

    public void modificarPedProd(PedidoProducto pedProd) { // 
        List<Pedido> pedList = new ArrayList();
        pedList = pedidoData.listarPedidosPorCobrada(false); //pedidos no cobrados
        List<Producto> prodList = new ArrayList();
        prodList = productoData.buscarProductoPorEstado(true);
        List<PedidoProducto> pedprodList = new ArrayList();
        pedprodList = this.obtenerCarrito();
        String sql = "UPDATE pedidoProducto SET idPedido=?, idProducto=?, cantidad=? where idPedidoProducto=?";
        boolean bandera = true;
        boolean bandera2 = false;
        //  PedidoProducto pedProd = new PedidoProducto();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pedProd.getIdPedido());
            ps.setInt(2, pedProd.getIdProducto());
            ps.setInt(3, pedProd.getCantidad());
            ps.setInt(4, pedProd.getIdPedidoProducto());

            for (Pedido listaPed : pedList) {
                if (listaPed.getIdPedido() == pedProd.getIdPedido()) { // verificacio
                    bandera = false;//si existe y está activo sera verdadero 

                }
            }
            for (Producto listaProd : prodList) {
                if (listaProd.getIdProducto() == pedProd.getIdProducto()) {
                    bandera2 = true;//{ si el producto tiene stock(está activo) y coincide con el idprod que intentamos agregar, debe poder cargar
                }
            }

            if (!bandera2) { //si es false no contamos con el producto 
                JOptionPane.showMessageDialog(null, "No contamos con ese producto");
            }
            if (!bandera && bandera2) {
                int cargado = ps.executeUpdate();
                if (cargado == 1) {
                    JOptionPane.showMessageDialog(null, " El carrito ha sido actualizado");
                } else {
                    JOptionPane.showMessageDialog(null, " no es posible modificar el pedido");

                }
            } else {
                JOptionPane.showMessageDialog(null, "no contamos con ese producto");
            }

        } catch (SQLException ex) {
            //Logger.getLogger(PedidoProductoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, " no es posible ingresar a la tabla pedidoProducto" + ex.getMessage());
        }

    }

    public void eliminarCarrito(int idProducto, int idPedido) { // ver idProducto (FALTA)
        List<Pedido> pedidoList = new ArrayList<>();
        pedidoList = pedidoData.listarPedidosPorCobrada(true);

        boolean bandera = false;
        String sql = "DELETE FROM pedidoproducto WHERE idProducto = ? AND idPedido=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ps.setInt(2, idPedido);
            for (Pedido lista : pedidoList) {
                if (lista.getIdPedido() == idPedido) {
                    bandera = true;                     // ENTONCES mesa cobrada, no puede eliminarse el pedido 
                }
            }

            if (!bandera) {
                int cargado = ps.executeUpdate();
                if (cargado == 1) {
                    JOptionPane.showMessageDialog(null, " carrito eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, " no se ha podido eliminar el pedido"); //agregar verificacion si pagado o no. si se encuentran pendiientes

                }
            } else {
                JOptionPane.showMessageDialog(null, " no se puede eliminar un pedido ya cobrado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto");
        }
    }

    public void eliminar(PedidoProducto PedProd) {
        //System.out.println("pipas 3:" + PedProd);
        List<Pedido> pedidoList = new ArrayList<>();
        pedidoList = pedidoData.listarPedidosPorCobrada(false);
        boolean bandera = false;
        String sql = "DELETE FROM pedidoproducto WHERE idPedidoProducto=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, PedProd.getIdPedidoProducto());
            //System.out.println("prueba:" + PedProd.getIdPedido());
            
            for (Pedido lista : pedidoList) {
                //System.out.println("pruebaaa" + lista.getIdPedido());
                if (lista.getIdPedido() == PedProd.getIdPedido()) {
                    bandera = true; // no cobrada

                }
            }
            if (bandera) {
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Carrito cancelado");
            } else {
                JOptionPane.showMessageDialog(null, "Mesa ya cobrada, no puede cancelar el pedido ");

            }

        } catch (SQLException ex) {
            //Logger.getLogger(PedidoProductoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al acceder al carrito");

        }

    }
}
