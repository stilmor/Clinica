import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Barra del menu del programa. Aparece en todas las ventanas.
public class MenuBar implements ActionListener {
    JMenuBar menuBar;
    JMenu opciones;
    JMenuItem salir;

    public MenuBar() {
        menuBar = new JMenuBar();
        opciones = new JMenu("Opciones");
        salir = new JMenuItem("Salir");
        menuBar.add(opciones);
        opciones.add(salir);

        salir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==salir){
            FisioNat.exit(0);
        }
    }
}