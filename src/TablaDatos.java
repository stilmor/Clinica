import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

public class TablaDatos extends JFrame implements MouseListener, ActionListener, WindowListener {
    JScrollPane scroll;
    String[] cabecera;
    Object[][] datos;
    DefaultTableModel dtm;
    JTable tabla;
    JPanel panel;
   JLabel etiqueta;
    JButton ver;
    JTextField uno;
    JTextField dos;
    JTextField tres;
    JButton mira;




    Statement stmt = null;
    Connection conn;
    String sqlNombre;
    String sqlApellido;



    public TablaDatos(Conexion conn, String sqlNombre, String sqlApellido)  {
        System.out.println(conn);
        this.conn = conn.conexion();
        this.sqlNombre=sqlNombre;
        this.sqlApellido=sqlApellido;

        setSize(800, 250);
        this.setTitle("Pacientes");
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initcomponent();
        //TODO: Hacer algo aqui cuando haya excepcion
        try {
          cargarDatosTable(sqlNombre,sqlApellido);
        }
        catch (InterruptedException e1) {e1.printStackTrace();}
        catch (SQLException e1) {e1.printStackTrace();}

    }

    private void initcomponent() {

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(93,35,182));
        this.addWindowListener(this);

        scroll = new JScrollPane();
        cabecera = new String[]{"Nombre", "Apellido"};
        dtm = new DefaultTableModel(datos, cabecera);
        tabla = new JTable(dtm);
        scroll.setViewportView(tabla);
        panel.add(scroll);
        scroll.setBounds(10, 35, 500, 125);
        scroll.setVisible(true);
        tabla.addMouseListener(this);


        this.setContentPane(panel);
        this.setVisible(true);
    }

    protected void cargarDatosTable(String sqlNombre, String sqlApellido) throws SQLException, InterruptedException {


        ResultSet rset;
        stmt = conn.createStatement();
        //sqlStr = "select * from personas";
        String sqlStr = "select * from pacientes where nombre="+"'"+sqlNombre+"'";
        rset = stmt.executeQuery(sqlStr);
        while (rset.next()) {
            String nombre = rset.getString("nombre");
            String apellido = rset.getString("apellido");

            dtm.addRow(new Object[]{nombre, apellido});





        /*dtm.addRow(new Object[]{1234, "JOSE", "MORENO"});
        dtm.addRow(new Object[]{1235, "MIGUEL", "MORENOA"});
        ResultSet rset = null;
        while (rset.next()) {
            String dni = rset.getString("f_DNI");
            String nombre = rset.getString("f_Nombre");
            String apellido = rset.getString("f_Apellido");

            dtm.addRow(new Object[]{dni, nombre, apellido});
        }*/

        }
    }
    void grabar() throws SQLException, IOException {
        ArrayList<String> lista = new ArrayList<>();

        stmt = (Statement) conn.createStatement();
        String sqlStr = "select * from personas";
        ResultSet rset = null;
        rset = stmt.executeQuery(sqlStr);
        while (rset.next()) {

            lista.add(rset.getString("nombre"));
            lista.add(rset.getString("edad"));

            for (String ver : lista) {
                System.out.println(ver);
            }
                /*System.out.println(rset.getString("nombre") + ", " +
                    rset.getString("edad"));*/
            FileWriter writer = new FileWriter("C:\\fichero\\TABLABASES.txt");
            BufferedWriter bwriter = new BufferedWriter(writer);
            Iterator<String> iterPer = lista.iterator();
            String pAux;
            while (iterPer.hasNext()) {
                pAux = iterPer.next();
                bwriter.write(pAux);
                bwriter.newLine();
            }
            bwriter.close();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       /*String item = (String) combo.getSelectedItem();
        //String item2= (String) combo.getSelectedItem();
        if (item=="todos"){
            int numFilas = dtm.getRowCount();
            for (int i = 0; i <numFilas ; i++) {
                dtm.removeRow(0);
            }
            try {
                cargarDatosTable(item);
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }*/
        //sacar filtro para todos
       /* else if (item2.equals("todos")){

            for (int i = 0; i <ite ; i++) {

            }
        }*/
    }





    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==tabla){
            String nombre = (String) dtm.getValueAt(tabla.getSelectedRow(),0);
            String apellido = (String) dtm.getValueAt(tabla.getSelectedRow(),1);


            try {
                Ventana3 info=new Ventana3(nombre,apellido,conn);
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }
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
