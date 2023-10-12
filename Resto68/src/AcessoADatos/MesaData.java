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
    ps.setInt(3, mesa.getCapacidad());
    ps.setBoolean(4, mesa.isEstadoDeMesa());
    
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
    public void estadoMesa(int id) {
        String sql = "UPDATE mesa SET estado=0 WHERE idProducto = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Mesa liberada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el estado de la mesa");
        }

    }
    
}
