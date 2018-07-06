import java.io.Serializable;
import java.util.Scanner;

public class Paciente implements Serializable{
    String nombre;
    String apellido;

    public Paciente(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nombre del paciente");
        nombre=sc.nextLine();
    }

    public Paciente(String nombrePaciente, String apellidoPaciente) {
        nombre=nombrePaciente;
        apellido=apellidoPaciente;
    }

    public Paciente(String nombrePaciente) {
        nombre=nombrePaciente;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object paciente) {
        Paciente pAux = (Paciente) paciente;

        if (nombre.equals(pAux.nombre)){
            return true;
        }
        return false;
    }
}
