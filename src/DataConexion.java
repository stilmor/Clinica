// Esta clase no hace nada, solo mantiene los datos del usuario password
// introducidos por el usuario en el UI.
public class DataConexion {
    final String username;
    final String password;
   
    public DataConexion(String user, String pass) {
      username = user;
      password = pass;
    }
    public String nombre_usuario() {
        return username;
    }
    public String password() {
        return password;
    }
  }
