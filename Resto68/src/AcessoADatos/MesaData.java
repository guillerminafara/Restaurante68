/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AcessoADatos;

import Entidades.Mesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class MesaData {
    
    private Connection con = null;
    
    public MesaData() {
    con = Conexion.getConexion();
    }
    
    public void crearMesa(Mesa mesa){
    String sql ="INSERT INTO mesa (idMesa, numero, capacidad, estado) VALUES(?,?,?,?)";
    
    try{
    PreparedStatement ps;
        ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1, mesa.getIdMesa());
    ps.setInt(2, mesa.getNumero());
    ps.setBoolean(3, mesa.isEstadoDeMesa());
    ps.setInt(4, mesa.getCapacidad());
    
    ps.executeUpdate();
    ResultSet rs = ps.getGeneratedKeys();
    if (rs.next()) {
    mesa.setIdMesa(rs.getInt(1));
    JOptionPane.showConfirmDialog(null,"Mesa agregada correctamente");
    } else { 
        JOptionPane.showConfirmDialog(null,"Algo anda mal");}
    ps.close();
    } catch (SQLException ex) {
            //Logger.getLogger(PedidoProductoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(null, "no se puede ingresar a la tabla pedidoProducto u.u" + ex.getMessage());

        }
    }
    
}
