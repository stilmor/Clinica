import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Optional;


public class Principal {
    Conexion conn;
    Ventana ventanaConnexion;

    public Principal() {
        // Devuelve una clase con el usuario y password
        datos_usuario_password()
            // Convierte a una clase conexion
            .map((datos) -> connectar(datos.nombre_usuario(), datos.password()))
            // Convierte a una clase Ventana2
            .map((connexion) -> new Ventana2(connexion.connexion()));
    }

    // TODO: evitar null
    public Conexion connectar(String usuario, String password) {
        try {
            Conexion conex = new Conexion(password, usuario);
            return conex;
           // delete ventanaConnexion;
           // panel.setVisible(false);
           /// this.dispose();

        } catch (SQLException e1) {
            e1.printStackTrace();
            return null;
        }
    }

    private Optional<DataConexion> datos_usuario_password() {
        JTextField text0 = new JTextField(10);
        JTextField text1 = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Usuario: "));
        panel.add(text0);
        panel.add(new JLabel("Password: "));
        panel.add(text1);
        String titulo_ventana = "Introduce usuario y password";

        int result = JOptionPane.showConfirmDialog(null, panel, titulo_ventana, JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
           return Optional.of(new DataConexion(text0.getText(), text1.getText()));
        } else {
            return Optional.empty();
        }
    }

}
