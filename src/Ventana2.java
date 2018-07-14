

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;

public class Ventana2 extends JFrame implements MouseListener,ActionListener,WindowListener {
    //TreeSet<Persona> listaper=new TreeSet<>();
    //Iterator<Persona> iterador=listaper.iterator();
    HashSet<Paciente> listap=new HashSet<>();
    Iterator<Paciente> iter=listap.iterator();

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
    Statement stmt = null;


    public Ventana2(Connection conn) throws SQLException {
        this.conn=conn;
        stmt = conn.createStatement();
        setSize(720, 720);
        this.setTitle("FisioNat");
        this.setResizable(false);
        this.addWindowListener(this);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
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



        nuevo.addMouseListener(this);
        buscar.addMouseListener(this);
        name.addMouseListener(this);
        apellido.addMouseListener(this);
        ape.addMouseListener(this);
        bus.addMouseListener(this);



        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(93,35,182));
        this.add(panel);

        panel.add(nuevo);
        panel.add(buscar);





        MenuBar menuBar= new MenuBar();
        menuBar.menuBar.setBounds(0,0,getWidth(),20);
        menuBar.salir.addActionListener(this);
        panel.add(menuBar.menuBar);


    }
    /*void coleccion() throws IOException {
     //aqui cargamos los archivos de el fichero de txt//
        FileReader carga= null;

        carga = new FileReader("c:\\fichero\\fichero.txt");
        BufferedReader lee=new BufferedReader(carga);
        ArrayList<String> contenedor= new ArrayList<>();
        String aux= null;

            aux = lee.readLine();
        int cont=0;
        while (aux!=null){
            String [] arrstring=aux.split(" ");
            String nombree=arrstring[0];
            int edada = Integer.parseInt(arrstring[1]);
            //String apellidoo=arrstring[2];
            Paciente nuevaPer=new Paciente(nombree,edada);
            //añadimos los datos a la coleccion.
            if (!listap.add(nuevaPer)){
                System.out.println(nuevaPer.nombre + " ya esta en la lista");
            }
            aux=lee.readLine();

        }

        for (Persona ver:listap) {

            System.out.println(ver.nombre +" "+ ver.edad);
        }
    }

    void volcar() throws SQLException {

        stmt = (Statement) conn.createStatement();
        for (Persona vol:listap) {
            String nombre=vol.nombre;
            int edad=vol.edad;
            String inse="insert into personas (nombre,edad) values ('"+nombre+"',"+edad+")";
                int rset = stmt.executeUpdate(inse);
        }
    }*/
    void consulta() throws InterruptedException, SQLException {

            String sqlNombre = name.getText();
            String sqlApellido=ape.getText();
            //name.setText("la consulta es:" + sqlStr);
            new TablaDatos(conn,sqlNombre,sqlApellido);




            //ResultSet rset = null;
            //rset = stmt.executeQuery(sqlNombre+sqlApellido);
            /*while (rset.next()){
                salida.setText(rset.getString("nombre") + ", " +
                       rset.getString("edad"));
            }*/

    }

    /*private void actua() throws SQLException {
        String sqlStr=entrada.getText();
        stmt = (Statement) conn.createStatement();
        System.out.println("el update es: " + sqlStr);
        int rset = stmt.executeUpdate(sqlStr);
    }*/

    /*private void borrar() {
        Iterator<Persona> iterador = listap.iterator();

        Persona perAux = new Persona();
        perAux.nombre = entrada.getText();
        Persona miAux;
        while (iterador.hasNext()) {
            miAux = iterador.next();
            if (miAux.nombre.compareTo(perAux.nombre) == 0) {
                iterador.remove();
                for (Persona ver:listap){
                    System.out.println(ver.nombre);
                }
            }

        }
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==menuBar.salir){
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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




    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (e.getSource()==this){
            Conexion cerrar=new Conexion();
            try {
                cerrar.cerrarcon();
                System.exit(0);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
