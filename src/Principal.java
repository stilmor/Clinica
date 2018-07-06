import java.sql.SQLException;

public class Principal {
    Conexion conn;
    Ventana ventanaConnexion;

    public void Principal() {
        Ventana ventanaConnexion=new Ventana(this);
    }
    public void setConexion(Conexion conex){
        conn=conex;
    }

    public void connectar(String usuario, String password) {
        try {
            Conexion conex = new Conexion(password, userName);
            delete ventanaConnexion;
           // panel.setVisible(false);
           /// this.dispose();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
