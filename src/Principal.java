import javax.swing.*;
import java.awt.*;
import java.util.Optional;
import javafx.util.Pair;

public class Principal {
    public Principal() {
        Conexion conn = null;
        do {
            Pair<String, String> usuario_password = pedir_usuario_password();
            conn =  new Conexion(usuario_password.getKey(), usuario_password.getValue());
            if (!conn.esta_connectado()) {
                String error = "La conexion a la base de datos ha fallado. Introduzca credenciales validas. ";
                JOptionPane.showMessageDialog(null, error);
            }
        } while(!conn.esta_connectado());
        new Ventana2(conn);
    }

    // TODO: esto puede ser otra clase
    private Pair<String, String> pedir_usuario_password() {
        JTextField user_text = new JTextField(10);
        JTextField password_text = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Usuario: "));
        panel.add(user_text);
        panel.add(new JLabel("Password: "));
        panel.add(password_text);
        String titulo_ventana = "Introduce usuario y password";

        JOptionPane.showMessageDialog(null, panel);//, titulo_ventana, JOptionPane.OK_CANCEL_OPTION);
        return new Pair<>(user_text.getText(), password_text.getText());
    }

}
