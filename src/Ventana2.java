import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Ventana2 {
    Conexion conn;

    public Ventana2(Conexion conn) {
        this.conn=conn;

        JFrame frame = new JFrame("FisioNat");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = initcomponent2();
        frame.add(mainPanel);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null); //centra en pantalla
        frame.setVisible(true);
    }

    // Estos 3 metodos es lo que realmente hace este UI
    private void accion_boton_nuevo() {
        new NuevoPaciente(conn);
    }

    private void accion_boton_buscar(String nombre, String apellido) {
        new TablaDatos(conn, nombre, apellido);
    }

    private void accion_boton_salir() {
        FisioNat.exit(0);
    }

    // De aqui para abajo solo son cosas de layout

    private JPanel initcomponent2() {
        JPanel panel = crear_panel_basico();
        panel.setLayout(new BorderLayout(10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Boton para crear nuevo paciente
        JButton nuevo = new JButton("Nuevo paciente");
        nuevo.setToolTipText("Rellena un nuevo paciente");
        nuevo.addActionListener(e -> accion_boton_nuevo());

        JPanel panel_nuevo = crear_panel_titulo("Nuevo paciente");
        set_layout_basico(panel_nuevo);
        panel_nuevo.add(nuevo);

        JPanel panel_buscar = FormularioBuscar();

        // Boton salir
        JButton salir = new JButton("Salir");
        salir.setToolTipText("Salir de la aplicacion");
        salir.addActionListener(e -> accion_boton_salir());

        JPanel panel_salir = crear_panel_basico();
        set_layout_basico(panel_salir);
        panel_salir.add(salir);

        //Ponerlos todos en ventana
        panel.add(panel_nuevo,BorderLayout.WEST);
        panel.add(panel_buscar,BorderLayout.EAST);
        panel.add(panel_salir, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel FormularioBuscar() {
        JPanel panel_buscar = crear_panel_titulo("Buscar paciente");
        panel_buscar.setLayout(new GridBagLayout());//GridLayout(3, 2));
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel nombre = new JLabel("Nombre:");
        nombre.setForeground(Color.white);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel_buscar.add(nombre, gbc);

        JTextField name = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel_buscar.add(name, gbc);

        JLabel apellido = new JLabel("Apellido:");
        apellido.setForeground(Color.white);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel_buscar.add(apellido, gbc);

        JTextField ape= new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel_buscar.add(ape, gbc);

        JButton bus = new JButton("Buscar");
        bus.setToolTipText("Buscar un paciente");
        bus.addActionListener(e -> accion_boton_buscar(name.getText(), ape.getText()));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel_buscar.add(bus, gbc);
        return panel_buscar;
    }

    private JPanel crear_panel_titulo(String titulo) {
        JPanel panel = crear_panel_basico();
        TitledBorder border = BorderFactory.createTitledBorder(titulo);
        border.setTitleColor(Color.white);
        panel.setBorder(border);
        return panel;
    }

    private JPanel crear_panel_basico() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(93,35,182));
        return panel;
    }

    private void set_layout_basico(JPanel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.add(Box.createHorizontalGlue());
    }

}
