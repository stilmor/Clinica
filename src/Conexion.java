import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class Conexion {
   private Optional<Connection> conn;

   // TODO: seguramente convertir en factory
    public Conexion(String userName, String password) {
        conn = null;
        String url = "jdbc:mysql:" + "//127.0.0.1/natalia";
        try {
            Connection conexion = DriverManager.getConnection(url, userName, password);
            conn = Optional.of(conexion);
            System.out.println("La conexion con la DB es correcta.");
        } catch(SQLException excepcion) {
            conn = Optional.empty();
            System.out.println("La conexion ha fallado.");
            System.out.println("Usuario: " + userName);
            excepcion.printStackTrace();
        }
    }

    public boolean esta_connectado() {
        return conn.isPresent();
    }

    public Optional<Connection> connexion() {
        return conn;
    }

    void cerrarcon() throws SQLException {
        conn.get().close();
        System.out.println("conexion cerrada");
    }

}
