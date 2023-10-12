/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AcessoADatos;

import Entidades.Pedido;
import Entidades.PedidoProducto;
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

    public PedidoProductoData() {
        con = Conexion.getConexion();

    }

    public void crearCarrito(PedidoProducto pedprod) { // ALTA de pedidosProductos
        String sql = "INSERT INTO pedidoproducto (idPedido, idProdcuto, cantidad) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedprod.getIdPedido());
            ps.setInt(2, pedprod.getIdProducto());
            ps.setInt(3, pedprod.getCantidad());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pedprod.setIdPedidoProducto(rs.getInt(1));
                JOptionPane.showConfirmDialog(null, "agregado correctamente");
            } else {
                JOptionPane.showConfirmDialog(null, "algo está mal, fijate");

            }
            ps.close();

        } catch (SQLException ex) {
            //Logger.getLogger(PedidoProductoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(null, "no se puede ingresar a la tabla pedidoProducto u.u" + ex.getMessage());

        }
    }

    public List<PedidoProducto> obtenerCarrito() { // METODO BUSCAR 
        List<PedidoProducto> listaPedProd = new ArrayList<>();
        String sql = "SELECT * FROM pedidoproducto";
        PedidoProducto pedProd = new PedidoProducto();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            pedProd.setIdPedido(rs.getInt("idPedido"));
            pedProd.setIdProducto(rs.getInt("idProducto"));
            pedProd.setCantidad(rs.getInt("cantidad"));
            listaPedProd.add(pedProd);
            ps.close();
        } catch (SQLException ex) {
           // Logger.getLogger(PedidoProductoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(null, "no se puede ingresar a la tabla pedidoProducto u.u" + ex.getMessage());

        }
        return listaPedProd;
    }
    
    public void modificarPedProdXidProd(int idPedido){ // metodo para modificar la cantidad de un producto en un producto 
        String sql="UPDATE pedidoProducto SET cantidad=? where idPedido=?";
        PedidoProducto pedProd= new PedidoProducto();
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, pedProd.getCantidad());
            ps.setInt(2, idPedido);
            int cargado= ps.executeUpdate();
            if(cargado==1){
                 JOptionPane.showMessageDialog(null," La cantidad del producto ha sido actualizada");
            }else{
                 JOptionPane.showMessageDialog(null," modificación cancelada");
               
            }
        } catch (SQLException ex) {
            //Logger.getLogger(PedidoProductoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null," no es posible ingresar a la tabla pedidoProducto" +  ex.getMessage());
        }
        
        
    }
    
    
    public List<PedidoProducto> obtenerCarritoXPedido(int idPedido ){ // metodo para devolver info desde la tabla PEDIDOPRDUCTO buscando por idPedido
        List <PedidoProducto>pedProdList= new ArrayList<>();
       
        String sql= "Select * FROM pedidoProducto where idPedido=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idPedido); // le paso el id con el que vamos a buscar en las listas o tablas
            ResultSet rs= ps.executeQuery(); //traigo info de la tabla
            while(rs.next()){
                PedidoProducto pedProd= new PedidoProducto();
                pedProd.setIdPedidoProducto(rs.getInt("idPedidoProducto"));
                pedProd.setIdProducto(rs.getInt("idProducto"));
                pedProd.setCantidad(rs.getInt("cantidad"));
                
            }
        } catch (SQLException ex) {
            //Logger.getLogger(PedidoProductoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
        
    }
}
