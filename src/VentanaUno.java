import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VentanaUno extends JFrame implements MouseListener,ActionListener {

    //variables globales
    int x=75;

    //********************************
    //Componentes del panel
    //********************************

    JPanel miPanel;
    JButton NuevoPaciente;
    JButton VerPaciente;
    JButton EliminarPaciente;


//********************************
    //Elementos del menu
    //********************************

    JMenuBar menuBar;
    JMenu Archivo;
    JMenuItem Panel2;
    JMenuItem Salir;
    JMenu Herramientas;
    JMenuItem tramposa;
    JMenuItem Volver;

//********************************
    //Componentes del panel 2
    //********************************
    JPanel miPanel2;
    JLabel etiq;
    JTextField registroUsu;
    JButton prueba;


    public VentanaUno(){
        //caracteristicas ventana

        this.setResizable(false);
        this.setTitle("FisioNat");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponent();
        initComponent2();

        this.setContentPane(miPanel);
        this.setVisible(true);
    }

    private void initComponent2() {
        miPanel2=new JPanel();
        miPanel2.setLayout(null);

        //etiquetas
        etiq=new JLabel("Registro de usuario");
        etiq.addMouseListener(this);
        etiq.setBounds(370,168,290,50);
        miPanel2.add(etiq);

        //cajas texto
        registroUsu=new JTextField();
        registroUsu.addMouseListener(this);
        registroUsu.setBounds(370,200,280,50);
        miPanel2.add(registroUsu);

        //botones

        prueba=new JButton("prueba");
        prueba.setBounds(370,270,280,50);
        prueba.addMouseListener(this);
        miPanel2.add(prueba);

        //menu barra
        menuBar=new JMenuBar();
        menuBar.setBounds(0,0,getWidth(),30);
        miPanel2.add(menuBar);

        Archivo=new JMenu("Archivo");
        menuBar.add(Archivo);

        Salir=new JMenuItem("Salir");
        Archivo.add(Salir);
        Salir.addActionListener(this);

        tramposa=new JMenu("Ayuda");
        menuBar.add(tramposa);

        Volver=new JMenuItem("Volver");
        Archivo.add(Volver);
        Volver.addMouseListener(this);


    }


    public void initComponent(){
        String aviso;
        aviso = (String) JOptionPane.showInputDialog("Esta aplicacion esta en Fase de pruebas por lo tanto aun contiene muchos errores");

        //tamaño del panel
        setSize(720,720);

        //instanciar contenedor Jpanel
        miPanel=new JPanel();
        //compoenentes sin layout
        miPanel.setLayout(null);

        //etiquetas


        //cajas texto


        //botones



        NuevoPaciente=new JButton("Nuevo Paciente");
        NuevoPaciente.addMouseListener(this);
        NuevoPaciente.setBounds(x,140,150,50);
        miPanel.add(NuevoPaciente);

        VerPaciente=new JButton("Ver Paciente");
        VerPaciente.setBounds(x,190,150,50);
        miPanel.add(VerPaciente);

        EliminarPaciente=new JButton("Eliminar Paciente");
        EliminarPaciente.setBounds(x,240,150,50);
        miPanel.add(EliminarPaciente);

        //Elementos del menu

        menuBar=new JMenuBar();
        menuBar.setBounds(0,0,720,30);
        miPanel.add(menuBar);

        Archivo=new JMenu("Archivo");
        menuBar.add(Archivo);

        Salir=new JMenuItem("Salir");
        Archivo.add(Salir);
        Salir.addActionListener(this);

        tramposa=new JMenu("Ayuda");
        menuBar.add(tramposa);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Salir){
            System.exit(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        if (arg0.getSource()== NuevoPaciente){

            setSize(720,720);
            setContentPane(miPanel2);
            this.setVisible(true);
            repaint();



            //Paciente nuevoPaciente=new Paciente();
            //Clinica nuevoPa=new Clinica();
            //registroUsu.setText("prueba");


            //VentanaUno nPaciente=new VentanaUno();
            //nuevoPa.registrar(nuevoPaciente);

            //System.out.println("Registro completado");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}


