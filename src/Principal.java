import javax.swing.*;
import java.awt.*;
import java.util.Optional;

public class Principal {
    public Principal() {
        Conexion conn =  new Conexion();
        if (!conn.esta_connectado()) {
            String error = "La conexion a la base de datos ha fallado. ";
            JOptionPane.showMessageDialog(null, error);
            FisioNat.exit(-1);
        }
        new Ventana2(conn);
    }
}
