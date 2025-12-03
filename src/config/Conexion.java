package config;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    Connection conectar=null;
    String servidor = "127.0.0.1";
    String baseDatos = "paqueteria_db";
    String usuario = "root";
    String password = "";
    public Connection conectar(){
       try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          //conectar=DriverManager.getConnection("jdbc:mysql:"
          //          + "//localhost/productos", "root","");
          conectar=DriverManager.getConnection("jdbc:mysql:"
                    + "//"+ servidor + "/" + baseDatos, usuario, password);
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
       }
       return conectar;
    }
}
