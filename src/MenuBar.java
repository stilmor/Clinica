import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar implements ActionListener {
    JMenuBar menuBar;
    JMenu tutorial;
    JMenuItem verTuto;
    JMenu opciones;
    JMenuItem salir;

    public MenuBar() {

        menuBar= new JMenuBar();
        tutorial=new JMenu("Tutorial");
        verTuto=new JMenuItem("Ver tutorial");
        opciones=new JMenu("Opciones");
        salir=new JMenuItem("Salir");
        salir.addActionListener(this);


        menuBar.add(tutorial);
        menuBar.add(opciones);
        tutorial.add(verTuto);
        opciones.add(salir);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==salir){
            System.exit(0);
        }
    }
}