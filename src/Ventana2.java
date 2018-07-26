import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class Ventana2 extends JFrame implements ActionListener {
    JPanel panel;
    JButton nuevo;
    JButton buscar;


    //en ventana de busqueda
    JLabel nombre;
    JTextField name;
    JLabel apellido;
    JTextField ape;
    JButton bus;

    MenuBar menuBar= new MenuBar();
    Connection conn;


    public Ventana2(Conexion conn) {
        this.conn=conn.connexion().get();
        setSize(720, 720);
        this.setTitle("FisioNat");
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initcomponent2();
        this.setContentPane(panel);
        this.setVisible(true);

        Toolkit toolkit= panel.getToolkit();
        Dimension size = toolkit.getScreenSize();

        setLocation(size.width/2 - panel.getWidth(), size.height/2 - panel.getHeight()/2);

    }

    private void initcomponent2() {
        System.out.println("componentes2");
        //caracteristicas de ventana


        //componentes de la ventana2

        nuevo = new JButton("Nuevo Paciente");
        nuevo.setBounds(50, 100, 160, 25);
        nuevo.setToolTipText("Rellena un nuevo paciente");
        buscar = new JButton("Buscar Paciente");
        buscar.setBounds(500, 100, 160, 25);
        buscar.setToolTipText("Busca un paciente");
        nombre = new JLabel("Nombre:");
        nombre.setForeground(Color.white);
        nombre.setBounds(500,140,50,25);
        name = new JTextField(20);
        name.setBounds(550,140,100,25);
        apellido = new JLabel("Apellido:");
        apellido.setBounds(500,175,50,25);
        apellido.setForeground(Color.white);
        ape= new JTextField(20);
        ape.setBounds(550,175,100,25);

        bus = new JButton(new ImageIcon("C:\\Users\\Raistlin\\IdeaProjects\\control\\Interfaz clinica\\Imagenes\\buscar.jpg"));
        bus.setBounds(550,250,50,50);

    //setNemonic
        //para el menu ejemplo close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

        //ImageIcon newIcon=new ImageIcon(interface);



        nuevo.addActionListener(this);
        buscar.addActionListener(this);
        name.addActionListener(this);
//        apellido.addActionListener(this);
        ape.addActionListener(this);
        bus.addActionListener(this);



        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(93,35,182));
        this.add(panel);

        panel.add(nuevo);
        panel.add(buscar);


        MenuBar menuBar= new MenuBar();
        menuBar.menuBar.setBounds(0,0,getWidth(),20);
        panel.add(menuBar.menuBar);
    }

    void consulta() throws InterruptedException, SQLException {
        String sqlNombre = name.getText();
        String sqlApellido=ape.getText();
        //name.setText("la consulta es:" + sqlStr);
        new TablaDatos(conn,sqlNombre,sqlApellido);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==buscar){
            panel.add(nombre);
            panel.add(name);
            panel.add(apellido);
            panel.add(ape);
            panel.add(bus);
            panel.repaint();
        }
        if (e.getSource()==bus){

            try {consulta();}

            catch (InterruptedException e1) {e1.printStackTrace();}

            catch (SQLException e1) {e1.printStackTrace();}
        }
        if (e.getSource()==nuevo){
            try {
                new NuevoPaciente(conn);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }


        /*if (e.getSource() == tabla) {
            System.out.println("pulsando tabla");
            mipanel2.setVisible(false);
            this.dispose();
            System.out.println(conn);
            try {
                TablaDatos nuevavent = new TablaDatos(conn);
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }*/

        /*else if (e.getSource()==colec){
            try {
                coleccion();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
        else if (e.getSource()==ins){
            try {
                volcar();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }

        else if (e.getSource() == consulta) {
            consulta();
        }
        else if (e.getSource()==update){
            try {
                actua();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        else if(e.getSource()==Delete){
            try {
                actua();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        else if (e.getSource()==boorrarcole){
            borrar();
        }*/
    }


}
