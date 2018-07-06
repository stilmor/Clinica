import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Ventana extends JFrame implements MouseListener,ActionListener,KeyListener {

    private JPanel panel;
    private JButton aceptar;
    private JButton cancelar;
    private JTextField usu;
    private JPasswordField pass;
    private JLabel usuario;
    private JLabel password;
    private Principal controlador;

    public Ventana(Principal principal) {
        setSize(300, 200);
        this.setTitle("Conexion");
        this.setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initcomponent();
        this.setContentPane(panel);
        this.setVisible(true);
        controlador = principal;
    }


    private void initcomponent() {
        usuario = new JLabel("Usuario");
        usuario.setForeground(Color.white);
        password = new JLabel("PassWord");
        password.setForeground(Color.white);
        usu = new JTextField(20);
        pass = new JPasswordField(20);
        aceptar = new JButton("Aceptar");
        cancelar = new JButton("Cancelar");

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(93,35,182));



        usuario.setBounds(70, 50, 90, 40);
        panel.add(usuario);
        password.setBounds(70, 90, 90, 20);
        panel.add(password);
        usu.setBounds(160, 60, 90, 20);
        panel.add(usu);
        pass.setBounds(160, 90, 90, 20);
        pass.addKeyListener(this);
        panel.add(pass);
        aceptar.setBounds(40, 150, 90, 20);
        panel.add(aceptar);
        aceptar.addMouseListener(this);
        aceptar.addKeyListener(this);
        cancelar.setBounds(150, 150, 100, 20);
        panel.add(cancelar);
        cancelar.addMouseListener(this);

        MenuBar menuBar = new MenuBar();
        menuBar.menuBar.setBounds(0, 0, getWidth(), 20);
        panel.add(menuBar.menuBar);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == aceptar) {
            char[] password = pass.getPassword();
            String userName = usu.getText();
            controlador.connectar(userName, password);


        } else if (e.getSource() == cancelar) {
            System.exit(0);
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
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            char[] password = pass.getPassword();
            String userName = usu.getText();

            try {
                Conexion conex = new Conexion(password, userName);
                panel.setVisible(false);
                this.dispose();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            aceptar.doClick();
        }
    }
}
