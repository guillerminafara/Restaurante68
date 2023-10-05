
package AcessoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    private static final String URL = "jdbc:mysql://localhost/restaurante68";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static Conexion conec = null;

    public Conexion() {
    }
    public static Connection getConexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {            
            JOptionPane.showMessageDialog(null, "error al cargar driver" + ex.getMessage());
        }
         Connection conectar = null;
        // si no hay conexiones previas..
        if (conec == null) { // ...entonces crea la unica conexion
            conec = new Conexion();
        }
        try {
            conectar = DriverManager.getConnection(URL, USUARIO, PASSWORD); //crea una conexion y la almacena en una variable de tipo Connection
        } catch (SQLException ex) {            
            JOptionPane.showMessageDialog(null, "error de conexion " + ex);
        }
        return conectar;
    }
} 

