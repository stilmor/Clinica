import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {
   static Connection conn;

    public Conexion(String password, String userName) throws SQLException {
        System.out.println("conexion");
        Statement stmt = null;
        conn = null;

        String url = "jdbc:mysql:" + "//127.0.0.1/natalia";
        //jdbc:sqlserver://server:port;DatabaseName=dbname

        conn = (Connection) DriverManager.getConnection(url, userName, String.valueOf(password));
        if (conn != null) {
            JOptionPane.showMessageDialog(null, "Conexion a base de datos " + url
                    + " ... Ok", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("mandando conexion" + conn);
         //   Ventana2 nuevaVent = new Ventana2(conn);

        }


    }

    public Conexion() {

    }

    void cerrarcon() throws SQLException {
        conn.close();
        System.out.println("conexion cerrada");
    }

}