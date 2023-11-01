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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MesaData {

    private Connection con = null;

    public MesaData() {
        con = Conexion.getConexion();
    }

    public void crearMesa(Mesa mesa) {
        String sql = "INSERT INTO mesa (idMesa, numero, capacidad, estado) VALUES(?,?,?,?)";

        try {
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
                JOptionPane.showMessageDialog(null, "Mesa agregada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Algo anda mal");
            }
            ps.close();
        } catch (SQLException ex) {
            //Logger.getLogger(PedidoProductoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no se puede ingresar a la tabla pedidoProducto u.u" + ex.getMessage());

        }
    }

    public void eliminar(int idMesa) {
        //System.out.println("pipas 3:" + PedProd);
        Mesa mesa = new Mesa();
        MesaData mesaData = new MesaData();
        mesa = mesaData.buscarMesaPorId(idMesa);
        boolean bandera = false;
        String sql = "DELETE FROM mesa WHERE idMesa=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMesa);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Mesa eliminada correctamente");
            }
            
        }catch (SQLException ex) {
            //Logger.getLogger(PedidoProductoData.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al acceder a la mesa");

        }

    }

    public void modificarMesa(Mesa mesa) {
        String sql = "UPDATE mesa SET numero=? , capacidad=?, estado=? WHERE idMesa = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, mesa.getNumero());
            ps.setInt(2, mesa.getCapacidad());
            ps.setBoolean(3, mesa.isEstadoDeMesa());
            ps.setInt(4, mesa.getIdMesa());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Mesa modificada correctamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar la mesa" + ex.getMessage());
        }
    }

    public List<Mesa> listarMesa() {
        List<Mesa> ListaDeMesas = new ArrayList<>();
        String sql = "SELECT * FROM mesa";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mesa mesa = new Mesa();
                mesa.setIdMesa(rs.getInt("idMesa"));
                mesa.setNumero(rs.getInt("numero"));
                mesa.setCapacidad(rs.getInt("capacidad"));
                mesa.setEstadoDeMesa(rs.getBoolean("estado"));
                ListaDeMesas.add(mesa);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla" + ex.getMessage());
        }
        return ListaDeMesas;
    }

    
    public List<Mesa> buscarMesaPorCapacidad(int capacidad) {
        
        List<Mesa> capacidadList = new ArrayList<>();
        
         for(Mesa capacidades : listarMesa()){
             if(capacidad == capacidades.getCapacidad()){
                 capacidadList.add(capacidades); //Estoy guardando la mesa con la capacidad buscada en el metodo listar que hicimos antes
             }
         }
        
        return capacidadList;
    }

    public Mesa buscarMesaPorNumero(int numero) {
        Mesa mesa = null;
        String sql = "SELECT idMesa, capacidad, estado FROM mesa WHERE numero=? ";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                mesa = new Mesa();
                mesa.setNumero(numero);
                mesa.setIdMesa(rs.getInt("idMesa"));
                mesa.setCapacidad(rs.getInt("capacidad"));
                mesa.setEstadoDeMesa(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe la mesa buscada");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesa;
    }

    public Mesa buscarMesaPorId(int idMesa) {
        Mesa mesa = null;
        String sql = "SELECT numero, capacidad, estado FROM mesa WHERE idMesa = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idMesa);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                mesa = new Mesa();
                mesa.setIdMesa(idMesa);
                mesa.setCapacidad(rs.getInt("Capacidad"));
                mesa.setNumero(rs.getInt("Numero"));
                mesa.setEstadoDeMesa(rs.getBoolean("Estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe tal mesa");
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla" + ex.getMessage());
        }
        return mesa;
    }

    public List<Mesa> buscarMesaPorEstado(boolean estado) {
        List<Mesa> listaDeMesas = new ArrayList<>();
        for (Mesa mesas : this.listarMesa()) {
            if (mesas.isEstadoDeMesa() == estado) {
                listaDeMesas.add(mesas);
            }
        }
        return listaDeMesas;
    }
}
