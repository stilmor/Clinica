import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.HashSet;
import java.sql.Statement;

public class Conexion {
    private Optional<Connection> conn;
    HashSet<String> tablas = new HashSet<>();


    // TODO: seguramente convertir en factory
    public Conexion() throws IOException {
        conn = null;
        // TODO: Por ahora la base de datos esta en memoria, esto hay que ponerlo en un fichero
        String url = "jdbc:sqlite::memory:";
        try {
            Connection conexion = DriverManager.getConnection(url);
            conn = Optional.of(conexion);
            System.out.println("La conexion con la DB es correcta.");
            comprobar_tablas();

        } catch (SQLException excepcion) {
            conn = Optional.empty();
            System.out.println("La conexion con" + url + " ha fallado.");
            excepcion.printStackTrace();
        }
    }

    public boolean esta_connectado() {
        return conn.isPresent();
    }

    public Connection conexion() {
        return conn.get();
    }

    void cerrarcon() throws SQLException {
        conexion().close();
        System.out.println("conexion cerrada");
    }

    private void comprobar_tablas() throws IOException, SQLException {
      //comando para crear tablas show create table [tabla]

      leer_Tablas();
      Statement stmt = conexion().createStatement();
      for (String content : tablas) {
        stmt.execute(content);
      }
        String comprobacion=".tables";
        //PENDIENTE VER LAS TABLAS CREADAS
        System.out.println(stmt.execute(comprobacion));

    }

        private void leer_Tablas() throws IOException {

            FileReader reader = new FileReader("C:\\Users\\Raistlin\\IdeaProjects\\control\\Interfaz clinica\\src\\tablas");
            BufferedReader buffer = new BufferedReader(reader);
            String aux = buffer.readLine();
            while (aux != null) {
                String[] arrString = aux.split("; ");
                String create = arrString[0];
                tablas.add(create);
                aux = buffer.readLine();
            }
        }
    }
