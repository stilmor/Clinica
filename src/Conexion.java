import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class Conexion {
   private Optional<Connection> conn;

   // TODO: seguramente convertir en factory
    public Conexion() {
        conn = null;
        // TODO: Por ahora la base de datos esta en memoria, esto hay que ponerlo en un fichero
        String url = "jdbc:sqlite::memory:";
        try {
            Connection conexion = DriverManager.getConnection(url);
            conn = Optional.of(conexion);
            System.out.println("La conexion con la DB es correcta.");
        } catch(SQLException excepcion) {
            conn = Optional.empty();
            System.out.println("La conexion con" + url + " ha fallado.");
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
