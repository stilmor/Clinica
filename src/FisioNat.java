import java.io.IOException;

public class FisioNat {
    public static void main(String[] args) throws IOException {
        new Principal();
    }
    public static void exit(int error_code) {
        System.out.println("La aplicacion ha finalizado ordenadamente con codigo de error: " + error_code);
        System.exit(error_code);
    }
}
