import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.HashSet;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class Ventana2 extends JFrame {
    JPanel panel;
    JButton nuevo;
    JButton salir;

    //en ventana de busqueda
    JLabel nombre;
    JTextField name;
    JLabel apellido;
    JTextField ape;
    JButton bus;

    Connection conn;

    public Ventana2(Conexion conn) {
        this.conn=conn.conexion();

        this.setTitle("FisioNat");
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel mainPanel = initcomponent2();
        this.setContentPane(mainPanel);
        this.setVisible(true);

        setSize(720, 720);
        Dimension size = mainPanel.getToolkit().getScreenSize();
        setLocation(size.width/2 - mainPanel.getWidth(), size.height/2 - mainPanel.getHeight()/2);
    }

    private JPanel initcomponent2() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(93,35,182));
        this.add(panel);

        nuevo = new JButton("Nuevo Paciente"); 
        nuevo.setBounds(50, 100, 160, 25);
        nuevo.setToolTipText("Rellena un nuevo paciente");
        nuevo.addActionListener(e -> nuevo());
        panel.add(nuevo);

        salir = new JButton("Salir");
        salir.setBounds(500, 500, 160, 25);
        salir.setToolTipText("Salir de la aplicacion");
        salir.addActionListener(e -> FisioNat.exit(0));
        panel.add(salir);

        nombre = new JLabel("Nombre:");
        nombre.setForeground(Color.white);
        nombre.setBounds(500,140,50,25);
        panel.add(nombre);
        name = new JTextField(20);
        name.setBounds(550,140,100,25);
        panel.add(name);
        apellido = new JLabel("Apellido:");
        apellido.setBounds(500,175,50,25);
        apellido.setForeground(Color.white);
        panel.add(apellido);
        ape= new JTextField(20);
        ape.setBounds(550,175,100,25);
        panel.add(ape);

        bus = new JButton(new ImageIcon("C:\\Users\\Raistlin\\IdeaProjects\\control\\Interfaz clinica\\Imagenes\\buscar.jpg"));
        bus.setBounds(550,250,50,50);
        bus.addActionListener(e -> consulta());
        panel.add(bus);

        return panel;
    }

    void consulta() {
        try {new TablaDatos(conn, name.getText(), ape.getText());}
        catch (InterruptedException e1) {e1.printStackTrace();}
        catch (SQLException e1) {e1.printStackTrace();}
    }

    private void nuevo() {
        try {
            new NuevoPaciente(conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
