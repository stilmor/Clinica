import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ventana3 extends JFrame implements ActionListener {

        JPanel panel;
        JLabel titulo;
        JLabel eNombre;
        JTextField nombre;
        JLabel eApellido;
        JTextField apellido;
        JLabel eFechaNacimiento;
        JTextField fechaNacimiento;
        JLabel eTelefono;
        JTextField telefono;
        JLabel eOcupacion;
        JTextField ocupacion;
        JLabel eAlergias;
        JTextField alergias;
        JLabel eMedicacion;
        JTextField medicacion;
        JLabel eEjercicio;
        JTextField ejercicio;
        JLabel eCirugia;
        JTextField cirugia;
        JLabel eDiagnostico;
        JButton diagnostico;
        JLabel eConsulta;
        JButton consulta;
        JLabel eValoracion;
        JButton valoracion;
        JLabel eTratamiento;
        JButton tratamiento;




        JButton cerrar;
        JButton historial;
        Statement stmt = null;
        Connection conn;

        public String id="";



    public Ventana3(String nombre, String apellido, Connection conn) throws SQLException, ParseException {
        this.conn=conn;
        mostrar(nombre,apellido);
        //hacer una query con el nombre extraido de la tabla y sacar de ahi los datos con la id de ese cliente
    }

    private void mostrar(String nom, String apell) throws SQLException, ParseException {

         id="select id from pacientes where nombre='"+nom+"'";
         stmt=(Statement) conn.createStatement();
         ResultSet rset= stmt.executeQuery(id);

        while (rset.next()){
            id=rset.getString("id");
        }

        panel =new JPanel();
        titulo= new JLabel("<html><h1><u>PACIENTE</u></h1></html>");
        titulo.setForeground(Color.white);
        titulo.setBounds(80,5,300,100);
        eNombre = new JLabel("Nombre:");
        eNombre.setForeground(Color.white);
        nombre = new JTextField(100);
        eNombre.setBounds(20, 100, 100, 25);
        nombre.setBounds(150, 100, 100, 25);
        eApellido = new JLabel("Apellido:");
        eApellido.setForeground(Color.white);
        apellido= new JTextField(100);
        eApellido.setBounds(20, 140, 100, 25);
        apellido.setBounds(150,140,100,25);
        eFechaNacimiento=new JLabel("Fecha de nacimiento:");
        eFechaNacimiento.setForeground(Color.white);
        fechaNacimiento = new JTextField(100);
        eFechaNacimiento.setBounds(20,180,150,25);
        fechaNacimiento.setBounds(150,180,100,25);
        eTelefono= new JLabel("Telefono:");
        eTelefono.setForeground(Color.white);
        telefono= new JTextField(100);
        eTelefono.setBounds(20,220,100,25);
        telefono.setBounds(150,220,100,25);
        eOcupacion= new JLabel("Ocupacion:");
        eOcupacion.setForeground(Color.white);
        ocupacion= new JTextField(100);
        eOcupacion.setBounds(20,260,100,25);
        ocupacion.setBounds(150,260,100,25);
        eAlergias=new JLabel("Alergias:");
        eAlergias.setForeground(Color.white);
        alergias=new JTextField(100);
        eAlergias.setBounds(20,300,100,25);
        alergias.setBounds(150,300,100,25);
        eMedicacion= new JLabel("Medicacion:");
        eMedicacion.setForeground(Color.white);
        medicacion= new JTextField(100);
        eMedicacion.setBounds(20,340,100,25);
        medicacion.setBounds(150,340,100,25);
        eEjercicio=new JLabel("Ejercicio:");
        eEjercicio.setForeground(Color.white);
        ejercicio=new JTextField(100);
        eEjercicio.setBounds(20,380,100,25);
        ejercicio.setBounds(150,380,100,25);
        eCirugia= new JLabel("Cirugias:");
        eCirugia.setForeground(Color.white);
        cirugia= new JTextField(100);
        eCirugia.setBounds(20,420,100,25);
        cirugia.setBounds(150,420,100,25);
        eDiagnostico=new JLabel("<html><u>Diagnostico</u>");
        eDiagnostico.setForeground(Color.white);
        eDiagnostico.setBounds(350,185,100,100);
        diagnostico = new JButton(new ImageIcon("C:\\Users\\Raistlin\\IdeaProjects\\control\\Interfaz clinica\\Imagenes\\historial.png"));
        diagnostico.setBounds(350,250,50,50);
        consulta=new JButton();
        consulta.setBounds(350,150,50,50);
        valoracion=new JButton();
        valoracion.setBounds(350,90,50,50);
        tratamiento=new JButton();
        tratamiento.setBounds(350,60,50,50);
        cerrar=new JButton("Cerrar");
        //historial=new JButton(new ImageIcon("C:\\Users\\Raistlin\\IdeaProjects\\control\\Interfaz clinica\\Imagenes\\historial.png"));

        setSize(600,600);
        this.setTitle("Ficha");
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(93,35,182));
        //panel.setForeground();
        this.add(panel);

        panel.add(titulo);
        panel.add(eNombre);
        panel.add(nombre);
        panel.add(eApellido);
        panel.add(apellido);
        panel.add(eFechaNacimiento);
        panel.add(fechaNacimiento);
        panel.add(eTelefono);
        panel.add(telefono);
        panel.add(eOcupacion);
        panel.add(ocupacion);
        panel.add(eAlergias);
        panel.add(alergias);
        panel.add(eMedicacion);
        panel.add(medicacion);
        panel.add(eEjercicio);
        panel.add(ejercicio);
        panel.add(eCirugia);
        panel.add(cirugia);
        panel.add(diagnostico);
        panel.add(consulta);
        panel.add(valoracion);
        panel.add(tratamiento);
        panel.add(eDiagnostico);



        this.setContentPane(panel);
        this.setVisible(true);

        cerrar.addActionListener(this);
        MenuBar menuBar= new MenuBar();
        menuBar.menuBar.setBounds(0,0,getWidth(),20);
        panel.add(menuBar.menuBar);
        datos(id);
    }


    private void datos(String id) throws SQLException, ParseException {


        String consulta="select * from pacientes,alergias_paciente,cirugias_paciente,consulta_paciente," +
                "diagnostico_paciente,ejercicio_paciente,medicacion_paciente,ocupacion_paciente,tratamiento_paciente," +
                "valoracion_paciente where pacientes.id="+id;
                stmt=(Statement) conn.createStatement();
                ResultSet rset= stmt.executeQuery(consulta);

            while (rset.next()){
                System.out.println(rset.getString("alergias"));
                System.out.println(rset.getString("telefono"));
                nombre.setText(rset.getString(
                        "apellido"));
                //fechaNacimiento.setText(rset.getString("fecha_nacimiento"));

                fechaNacimiento.setText(cambiarFecha(rset.getString("fecha_nacimiento")));
                telefono.setText(rset.getString("telefono"));
                ocupacion.setText(rset.getString("ocupacion"));
                alergias.setText(rset.getString("alergias"));
                medicacion.setText(rset.getString("medicacion"));
                ejercicio.setText(rset.getString("ejercicio"));
                cirugia.setText(rset.getString("cirugia"));
            }
        }

    private String cambiarFecha(String fecha_nacimiento) throws ParseException {
        System.out.println("entra");
        SimpleDateFormat fomato= new SimpleDateFormat("dd/MM/yyyy");
        Date fechaBuena=fomato.parse(fecha_nacimiento);
        String nuevaFecha=fechaBuena.toString();
        System.out.println(nuevaFecha);

        return nuevaFecha;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==cerrar){
            this.dispose();
        }
    }
}
