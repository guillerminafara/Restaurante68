
package AcessoADatos;

import Entidades.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class PedidoData {
    private Connection con = null;

    public PedidoData() {
        con = Conexion.getConexion();
    }
    
    public void agregarPedido(Pedido pedido){
        String sql ="INSERT INTO pedido (idMesa, nombreMesero, fechaHora, importe, cobrada) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS );
            ps.setInt(1, pedido.getIdMesa());
            ps.setString(2, pedido.getNombreMesero());
            ps.setDate(3, Date.from((pedido.getFechaHora().atZone(ZoneId.systemDefault()))).toInstant);//convierto de localdate a zonedate para poder hacerlo instant y poder pasarlo a date
            ps.setDouble(4, pedido.getImporte());
            ps.setBoolean(5, pedido.isCobrada());
            List<Pedido> listaDePedidos = new ArrayList<>();
            listaDePedidos = listarPedidos();
            boolean bandera = true;
            for(Pedido pedidoDeLista:listaDePedidos){
                if(pedido.getIdMesa()==pedidoDeLista.getIdMesa()&&!(pedido.getNombreMesero().equalsIgnoreCase(pedidoDeLista.getNombreMesero())))
                        bandera=false;
            }
            if (!bandera) {
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
        String sql = "UPDATE producto SET nombre=?, tipoProducto=?, stock=?, precio=?, estado=? WHERE IdProducto=? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getIdMesa());
            ps.setString(2, pedido.getNombreMesero());
            ps.setDate(3, Date.from((pedido.getFechaHora().atZone(ZoneId.systemDefault()))).toInstant);//convierto de localdate a zonedate para poder hacerlo instant y poder pasarlo a date
            ps.setDouble(4, pedido.getImporte());
            ps.setBoolean(5, pedido.isCobrada());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Producto modificado");
            }

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
                pedido.setNombreMesero(rs.getString("nombreMesero"));
                pedido.setFechaHora((rs.getDate("fechaHora").toInstant().atZone(ZoneId.systemDefault())).toLocalDateTime());//convierto a zonedate luego a localdate
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
    
}
