import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;


public class NuevoPaciente extends JFrame implements MouseListener,ActionListener,WindowListener {
    //TreeSet<Persona> listaper=new TreeSet<>();
    //Iterator<Persona> iterador=listaper.iterator();
    HashSet<Paciente> listap=new HashSet<>();
    Iterator<Paciente> iter=listap.iterator();

    //componentes ventana de registro

    JPanel panel;
    JButton registrar;
    JButton cancelar;
    JButton volver;

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
    TextArea diagnostico;
    JLabel eConsulta;
    TextArea consulta;
    JLabel eValoracion;
    TextArea valoracion;
    JLabel eTratamiento;
    TextArea tratamiento;

    //menuBar cargado desde una clase propia
    MenuBar menuBar= new MenuBar();
    Connection conn;
    Statement stmt = null;
    public String idPaciente ="";


    public NuevoPaciente (Connection conn) throws SQLException {
        this.conn=conn;
        stmt = conn.createStatement();
        setSize(1024,1024);
        this.setTitle("Nuevo Paciente");
        this.setResizable(false);
        this.addWindowListener(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initcomponent();
        this.setContentPane(panel);
        this.setVisible(true);

    }

    private void initcomponent() {
        //caracteristicas de ventana
        titulo= new JLabel("<html><h1><u>NUEVO PACIENTE</u></h1></html>");
        titulo.setForeground(Color.white);
        titulo.setBounds(420,10,300,100);
        eNombre = new JLabel("Nombre:");
        eNombre.setForeground(Color.white);
        nombre = new JTextField(100);
        eNombre.setBounds(20, 100, 100, 25);
        nombre.setBounds(150, 100, 150, 25);
        eApellido = new JLabel("Apellido:");
        eApellido.setForeground(Color.white);
        apellido= new JTextField(100);
        eApellido.setBounds(20, 140, 100, 25);
        apellido.setBounds(150,140,150,25);
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
        ocupacion.setBounds(150,260,150,25);
        eAlergias=new JLabel("Alergias:");
        eAlergias.setForeground(Color.white);
        alergias=new JTextField(100);
        eAlergias.setBounds(20,300,100,25);
        alergias.setBounds(150,300,150,25);
        eMedicacion= new JLabel("Medicacion:");
        eMedicacion.setForeground(Color.white);
        medicacion= new JTextField(100);
        eMedicacion.setBounds(20,340,100,25);
        medicacion.setBounds(150,340,150,25);
        eEjercicio=new JLabel("Ejercicio:");
        eEjercicio.setForeground(Color.white);
        ejercicio=new JTextField(100);
        eEjercicio.setBounds(20,380,100,25);
        ejercicio.setBounds(150,380,150,25);
        eCirugia= new JLabel("Cirugias:");
        eCirugia.setForeground(Color.white);
        cirugia= new JTextField(100);
        eCirugia.setBounds(20,420,100,25);
        cirugia.setBounds(150,420,150,25);
        eConsulta= new JLabel("<html><u>Consulta<u>:");
        eConsulta.setForeground(Color.white);
        consulta= new TextArea();
        eConsulta.setBounds(435,570,100,25);
        consulta.setBounds(550,570,250,200);
        eTratamiento=new JLabel("<html><u>Tratamiento</u>:");
        eTratamiento.setForeground(Color.white);
        tratamiento= new TextArea();
        eTratamiento.setBounds(435,780,100,25);
        tratamiento.setBounds(550,780,250,200);
        eDiagnostico= new JLabel("<html><u>Diagnostico</u>:");
        eDiagnostico.setForeground(Color.white);
        diagnostico= new TextArea(100,100);
        eDiagnostico.setBounds(20,570,100,25);
        diagnostico.setBounds(150,570,250,200);
        eValoracion= new JLabel("<html><u>Valoracion</u>:");
        eValoracion.setForeground(Color.white);
        valoracion= new TextArea();
        eValoracion.setBounds(20,780,100,25);
        valoracion.setBounds(150,780,250,200);
        registrar=new JButton("Registrar");
        registrar.setBounds(420,220,100,25);
        registrar.addMouseListener(this);
        cancelar= new JButton("Cancelar");
        cancelar.setBounds(570,220,100,25);

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
        panel.add(eDiagnostico);
        panel.add(diagnostico);
        panel.add(eConsulta);
        panel.add(consulta);
        panel.add(eValoracion);
        panel.add(valoracion);
        panel.add(eTratamiento);
        panel.add(tratamiento);
        panel.add(registrar);
        panel.add(cancelar);

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

       /* String sqlNombre = name.getText();
        String sqlApellido=ape.getText();*/
        //name.setText("la consulta es:" + sqlStr);
   //     new TablaDatos(conn,sqlNombre,sqlApellido);




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
    /*private void insertar() throws SQLException {
        String rNombre=nombre.getText();
        String rApellido=apellido.getText();
        String rNacimiento=fechaNacimiento.getText();
        //INSERT INTO demo (fecha)
        //VALUES (STR_TO_DATE(REPLACE('15/01/2005','/','.') ,GET_FORMAT(date,'EUR')))
        //String sqlStr = nombre.getText();
        String rTelefono=telefono.getText();
        String creadoEn="now()";
        String moidificado="now()";
        String rOcupacion=ocupacion.getText();
        String sqlStr="insert into pacientes (nombre,apellido,fecha_nacimiento,telefono,creado_en,modificado) values"+
                "('"+rNombre+"','"+rApellido+"'," + rNacimiento+ ","+rTelefono+","+creadoEn+","+moidificado+")";
        registro(sqlStr);
        sqlStr="insert into ocupacion_paciente (ocupacion,paciente_id) values ('"+rOcupacion+"',last_insert_id())";
        registro(sqlStr);
        sqlStr="insert into alergias_paciente (alergias,id_paciente) values ('"+alergias.getText()+"',last_insert_id())";
        registro(sqlStr);
        sqlStr="insert into medicacion_paciente (medicacion,id_paciente) values ('"+medicacion.getText()+"',last_insert_id())";
        registro(sqlStr);
        sqlStr="insert into ejercicio_paciente (ejercicio,id_paciente) values ('"+ejercicio.getText()+"', last_insert_id())";
        registro(sqlStr);
        sqlStr="insert into cirugias_paciente (cirugia,id_paciente) values ('"+cirugia.getText()+"', last_insert_id())";
        registro(sqlStr);
        sqlStr="insert into diagnostico_paciente (diagnostico,id_paciente) values ('"+diagnostico.getText()+"',last_insert_id())";
        registro(sqlStr);
        sqlStr="insert into consulta_paciente (consulta,id_paciente) values ('"+consulta.getText()+"',last_insert_id())";
        registro(sqlStr);
        sqlStr="insert into valoracion_paciente (valoracion,id_paciente) values ('"+valoracion.getText()+"',last_insert_id())";
        registro(sqlStr);


    }*/
    private void reg() throws SQLException, ParseException {
        String rNombre=nombre.getText();
        String rApellido=apellido.getText();
        java.sql.Date rNacimiento=cambiarFormato(fechaNacimiento.getText());
        System.out.println(rNacimiento);
        String rTelefono=telefono.getText();
        String creadoEn="now()";
        String moidificado="now()";
        String rOcupacion=ocupacion.getText();

        Date date = new Date();
        java.sql.Date ahora = new java.sql.Date(date.getTime());

        String sqlStr="INSERT INTO pacientes (nombre,apellido,fecha_nacimiento,telefono,creado_en,modificado) VALUES (?,?,?,?,?,?)";
        PreparedStatement statement_paciente=conn.prepareStatement(sqlStr);

        statement_paciente.setString(1, rNombre);
        statement_paciente.setString(2, rApellido);
        statement_paciente.setDate(3, rNacimiento);
        statement_paciente.setString(4, rTelefono);
        statement_paciente.setDate(5, ahora);
        statement_paciente.setDate(6, ahora);
        statement_paciente.execute();


        sqlStr="insert into ocupacion_paciente (ocupacion,paciente_id) values ('"+rOcupacion+"',"+id()+")";
        System.out.println("ha devuelto id");
        registro(sqlStr);
        sqlStr="insert into alergias_paciente (alergias,paciente_id) values ('"+alergias.getText()+"',"+idPaciente+")";
        registro(sqlStr);
        sqlStr="insert into medicacion_paciente (medicacion,paciente_id) values ('"+medicacion.getText()+"',"+idPaciente+")";
        registro(sqlStr);
        sqlStr="insert into ejercicio_paciente (ejercicio,paciente_id) values ('"+ejercicio.getText()+"',"+idPaciente+")";
        registro(sqlStr);
        sqlStr="insert into cirugias_paciente (cirugia,paciente_id) values ('"+cirugia.getText()+"', "+idPaciente+")";
        registro(sqlStr);
        sqlStr="insert into diagnostico_paciente (diagnostico,paciente_id) values ('"+diagnostico.getText()+"',"+idPaciente+")";
        registro(sqlStr);
        sqlStr="insert into consulta_paciente (consulta,paciente_id) values ('"+consulta.getText()+"',"+idPaciente+")";
        registro(sqlStr);
        sqlStr="insert into valoracion_paciente (valoracion,paciente_id) values ('"+valoracion.getText()+"',"+idPaciente+")";
        registro(sqlStr);
        sqlStr="insert into tratamiento_paciente (tratamiento,paciente_id) values ('"+tratamiento.getText()+"',"+idPaciente+")";
        registro(sqlStr);
        sqlStr="fin";
        registro(sqlStr);
    }

    private java.sql.Date cambiarFormato(String rNacimiento) throws ParseException {
        SimpleDateFormat formateador= new SimpleDateFormat("dd/MM/yyyy");
        Date dateStr = formateador.parse(rNacimiento);
        java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
        return dateDB;
    }


    private String id() throws SQLException {
        System.out.println("entrando en id");
        String lastId="select last_insert_id();";
        stmt=(Statement) conn.createStatement();
        ResultSet rset= stmt.executeQuery(lastId);

        while (rset.next()){
            idPaciente=rset.getString("last_insert_id()");
        }

        return idPaciente;
    }

    private void registro(String sqlStr) throws SQLException {
        conn.setAutoCommit(false);
        stmt = (Statement) conn.createStatement();
        if (sqlStr.compareTo("fin")==0){
            conn.commit();
            JOptionPane.showMessageDialog(null, "Registro completado correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
        /*String rNombre=nombre.getText();
        String rApellido=apellido.getText();
        String rNacimiento=fechaNacimiento.getText();
        String rTelefono=telefono.getText();
        String creadoEn="now()";
        String moidificado="now()";
        String rOcupacion=ocupacion.getText();
        String sqlStr="insert into pacientes (nombre,apellido,fecha_nacimiento,telefono,creado_en,modificado) values"+
                "('"+rNombre+"','"+rApellido+"'," + rNacimiento+ ","+rTelefono+","+creadoEn+","+moidificado+")";*/
            int rset = stmt.executeUpdate(sqlStr);
            //sqlStr="insert into ocupacion_paciente (ocupacion,paciente_id) values ('"+rOcupacion+"',last_insert_id())";
            //rset=stmt.executeUpdate(sqlStr);
            //conn.commit();

        /*salida.setText("la consulta es:" + sqlStr);
        ResultSet rset = null;
        rset = stmt.executeQuery(sqlStr);
        while (rset.next()) {
            salida.setText(rset.getString("pru_numero") + ", " +
                    rset.getString("pru_texto"));w
        }/*

        /*String insert;
        stmt = (Statement) conn.createStatement();
        System.out.println("indica la insercion");
        insert=sc.nextLine();
        String sqlStr = insert;
        System.out.println("la insercion es: " + sqlStr);
        int rset = stmt.executeUpdate(sqlStr);*/
        }
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==menuBar.salir){
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
            if (e.getSource()==registrar){
                try {
                    reg();
                    //registro(sqlStr);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
            }


        /* if (e.getSource()==buscar){
            mipanel2.add(nombre);
            mipanel2.add(name);
            mipanel2.add(apellido);
            mipanel2.add(ape);
            mipanel2.add(bus);
            mipanel2.repaint();
        }
        if (e.getSource()==bus){

            try {consulta();}

            catch (InterruptedException e1) {e1.printStackTrace();}

            catch (SQLException e1) {e1.printStackTrace();}
        }*/


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