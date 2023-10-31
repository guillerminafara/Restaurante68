
package AcessoADatos;

import Entidades.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PedidoData {
    private Connection con = null;

    public PedidoData() {
        con = Conexion.getConexion();
    }
    
    public void agregarPedido(Pedido pedido){
        String sql ="INSERT INTO pedido (idMesa, mesero, fechaHora, importe, cobrada) VALUES(?,?,?,?,?)";
        java.sql.Timestamp sqlTimestamp = java.sql.Timestamp.valueOf(pedido.getFechaHora());
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS );
            ps.setInt(1, pedido.getIdMesa());
            ps.setString(2, pedido.getNombreMesero());
            ps.setTimestamp(3, sqlTimestamp);
            ps.setDouble(4, pedido.getImporte());
            ps.setBoolean(5, pedido.isCobrada());
            List<Pedido> listaDePedidos = new ArrayList<>();
            listaDePedidos = listarPedidos();
            boolean bandera = true;
            for(Pedido pedidoDeLista:listaDePedidos){
                if(pedido.getIdMesa()==pedidoDeLista.getIdMesa()&&!(pedido.getNombreMesero().equalsIgnoreCase(pedidoDeLista.getNombreMesero())))
                        bandera=false;
            }
            if (bandera) {
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Pedido agregado correctamente");
                }

            } else {
                JOptionPane.showMessageDialog(null, "La mesa corresponde a otro mesero");
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto." + ex.getMessage());
        }
        
    }
    
    public void eliminarPedido(int id) {
        String sql = "UPDATE pedido SET estado=0 WHERE idPedido = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Pedido eliminado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido");
        }

    }
    
    public void modificarPedido(Pedido pedido) {
        String sql = "UPDATE pedido SET idMesa=?, mesero=?, fechaHora=?, importe=?, cobrada=? WHERE idPedido=? ";
        java.sql.Timestamp sqlTimestamp = java.sql.Timestamp.valueOf(pedido.getFechaHora());
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getIdMesa());
            ps.setString(2, pedido.getNombreMesero());
            ps.setTimestamp(3, sqlTimestamp);
            ps.setDouble(4, pedido.getImporte());
            ps.setBoolean(5, pedido.isCobrada());
            List<Pedido> listaDePedidos = new ArrayList<>();
            listaDePedidos = listarPedidos();
            boolean bandera = true;
            for(Pedido pedidoDeLista:listaDePedidos){
                if(pedido.getIdMesa()==pedidoDeLista.getIdMesa()&&!(pedido.getNombreMesero().equalsIgnoreCase(pedidoDeLista.getNombreMesero())))
                        bandera=false;
            }
            ps.setInt(6, pedido.getIdPedido());
            if(bandera){
                int exito = ps.executeUpdate();
                if (exito == 1)                    
                    JOptionPane.showMessageDialog(null, "Pedido modificado");
            }else {
                JOptionPane.showMessageDialog(null, "La mesa corresponde a otro mesero");
            }
            ps.close();
        } catch (SQLException ex) {            
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto" + ex.getMessage());

        }
        
    }
    
    public List<Pedido> listarPedidos(){
        List<Pedido> listaDePedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setIdMesa(rs.getInt("idMesa"));
                pedido.setNombreMesero(rs.getString("mesero"));
                java.sql.Timestamp sqlTimestamp = rs.getTimestamp("fechaHora");
                pedido.setFechaHora(sqlTimestamp.toLocalDateTime());
                pedido.setImporte(rs.getDouble("importe"));
                pedido.setCobrada(rs.getBoolean("cobrada"));
                listaDePedidos.add(pedido);                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla" + ex.getMessage());
        }
        
        return listaDePedidos;
    }
    
    public Pedido buscarPedidoPorId(int idPedido){
        Pedido pedido = null;
        String sql = "SELECT idMesa, mesero, fechaHora, importe, cobrada FROM pedido WHERE idPedido=? ";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pedido = new Pedido();
                pedido.setIdPedido(idPedido);
                pedido.setIdMesa(rs.getInt("idMesa"));
                pedido.setNombreMesero(rs.getString("mesero"));
                java.sql.Timestamp sqlTimestamp = rs.getTimestamp("fechaHora");
                pedido.setFechaHora(sqlTimestamp.toLocalDateTime());
                pedido.setImporte(rs.getDouble("importe"));
                pedido.setCobrada(rs.getBoolean("cobrada"));
            }else {
                JOptionPane.showMessageDialog(null, "No existe el pedido buscado");                
            }
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(PedidoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedido;
        
    }
    
    public List<Pedido> listarPedidosPorMesa(int idMesa){
        List<Pedido> pedidosPorMesa = new ArrayList<>();
        for(Pedido pedido :this.listarPedidos()){
            if(idMesa==pedido.getIdMesa())
                pedidosPorMesa.add(pedido);
        }
        Collections.sort(pedidosPorMesa,comparaMesa);
        return pedidosPorMesa;
    }
    
    public static Comparator<Pedido> comparaMesa = new Comparator<Pedido>() { 
        @Override
        public int compare(Pedido  p1, Pedido p2) {
            return p2.getIdMesa() < p1.getIdMesa() ?-1 :(p2.getIdMesa()==p1.getIdMesa() ?0:1);
        }
    };
    
    public List<Pedido> listarPedidosPorMesero(String mesero){
        List<Pedido> pedidosPorMesero = new ArrayList<>();
        for(Pedido pedido :this.listarPedidos()){
            if(mesero.equalsIgnoreCase(pedido.getNombreMesero()))
                pedidosPorMesero.add(pedido);
        }
        Collections.sort(pedidosPorMesero,comparaMesero);
        return pedidosPorMesero;
    }    
    
    public static Comparator<Pedido> comparaMesero = new Comparator<Pedido>() { 
        @Override
        public int compare(Pedido  p1, Pedido p2) {
            return p1.getNombreMesero().compareTo(p2.getNombreMesero());
        }
    };
    
    public List<Pedido> listarPedidosPorCobrada(boolean cobrada){
        List<Pedido> pedidosPorCobrada = new ArrayList<>();
        for(Pedido pedido :this.listarPedidos()){
            if(cobrada == pedido.isCobrada())
                pedidosPorCobrada.add(pedido);
        }        
        return pedidosPorCobrada;
    }    
    
    public List<Pedido> listarPedidosPorImporte(double bot, double top){
        List<Pedido> pedidosPorImporte = new ArrayList<>();
        for(Pedido pedido :this.listarPedidos()){
            if(pedido.getImporte()>=bot&&pedido.getImporte()<=top)
                pedidosPorImporte.add(pedido);
        }
        Collections.sort(pedidosPorImporte,comparaImporte);
        return pedidosPorImporte;
    }    
    
    public static Comparator<Pedido> comparaImporte = new Comparator<Pedido>() { 
        @Override
        public int compare(Pedido  p1, Pedido p2) {
            return p2.getImporte() < p1.getImporte() ?-1 :(p2.getImporte()==p1.getImporte() ?0:1);
        }
    };
    
    public List<Pedido> listarPedidosPorFecha(LocalDate bot, LocalDate top){
        List<Pedido> pedidosPorImporte = new ArrayList<>();        
        for(Pedido pedido :this.listarPedidos()){
            LocalDate fecha = pedido.getFechaHora().toLocalDate();            
            if((fecha.isAfter(bot)||fecha.isEqual(bot))&&(fecha.isBefore(top)||fecha.isEqual(top)))
                pedidosPorImporte.add(pedido);
        }
        Collections.sort(pedidosPorImporte,comparaFechaHora);
        return pedidosPorImporte;
    }    
    
    public List<Pedido> listarPedidosPorHora(LocalTime bot, LocalTime top){
        List<Pedido> pedidosPorImporte = new ArrayList<>();        
        for(Pedido pedido :this.listarPedidos()){
            LocalTime hora = pedido.getFechaHora().toLocalTime();            
            if((hora.isAfter(bot)||hora.equals(bot))&&(hora.isBefore(top)||hora.equals(top)))
                pedidosPorImporte.add(pedido);
        }
        Collections.sort(pedidosPorImporte,comparaFechaHora);
        return pedidosPorImporte;
    } 
    
    public static Comparator<Pedido> comparaFechaHora = new Comparator<Pedido>() { 
        @Override
        public int compare(Pedido  p1, Pedido p2) {
            return p1.getFechaHora().compareTo(p2.getFechaHora());
        }
    };
}