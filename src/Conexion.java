import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.HashSet;

public class Conexion {
   private Optional<Connection> conn;

   // TODO: seguramente convertir en factory
    public Conexion() throws IOException {
        conn = null;
        // TODO: Por ahora la base de datos esta en memoria, esto hay que ponerlo en un fichero
        String url = "jdbc:sqlite::memory:";
        try {
            Connection conexion = DriverManager.getConnection(url);
            conn = Optional.of(conexion);
            System.out.println("La conexion con la DB es correcta.");
            leer_Tablas();
        } catch(SQLException excepcion) {
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

    private void comprobar_tablas(){
        //comando para crear tablas show create table [tabla]

        /*hola ein hola
        mimi trusmi
         */

        /*String creaTablas="CREATE TABLE `pacientes` (`id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `nombre` varchar(100) NOT NULL,\n" +
                "  `apellido` varchar(100) NOT NULL,\n" +
                "  `fecha_nacimiento` date DEFAULT NULL,\n" +
                "  `telefono` int(9) DEFAULT NULL,\n" +
                "  `creado_en` date NOT NULL,\n" +
                "  `modificado` date NOT NULL,\n" +
                "  PRIMARY KEY (`id`))";*/
    }

    private void leer_Tablas() throws IOException {
        HashSet<String>tablas=new HashSet<String>();

        FileReader reader= new FileReader("C:\\Users\\Raistlin\\IdeaProjects\\control\\Interfaz clinica\\src\\tablas");
        BufferedReader buffer= new BufferedReader(reader);

        while (buffer.readLine()!=null){
            System.out.println("en el while");
            String [] arrString=buffer.readLine().split(";");
            String create=arrString[0];
            tablas.add(create);
        }
        for (String content:tablas) {
            System.out.println(content);
            System.out.println("leyendo");
        }
        System.out.println("leido");


    }
}
