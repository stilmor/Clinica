import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Clinica {
static HashSet<Paciente> listaPacientes=new HashSet<>();
static Iterator<Paciente> iterador=listaPacientes.iterator();
static ArrayList<String> listaprueba=new ArrayList<>();

    void repetidos(String nombre) {

        listaprueba.add(nombre);
    }

    /*public static void main(String[] args) throws IOException, ClassNotFoundException {
        Clinica miClinica=new Clinica();
        int opcion=menu();
        while (opcion!=0){
            if (opcion==1){
                Paciente nuevoPaciente=new Paciente();
                miClinica.registrar(nuevoPaciente);
            }
            else if (opcion==2){
                miClinica.VerPacientes();
            }
            else if (opcion==3){
                miClinica.borrar();
            }
            else if (opcion==4){
                miClinica.total();
            }
            else if (opcion==5){
                miClinica.guardar();
            }
            else if (opcion==6){
                miClinica.cargarlista();
            }
            //opcion para hacer pruebas
            else if (opcion==7){
                /* //List<String> nombres=listaPacientes.stream().map().collect(Collectors.toList());
                //Iterator<String> iter=nombres.iterator();
                String cont;
                while (iter.hasNext()){
                    cont=iter.next();
                    System.out.println();
                }*//*
                Scanner sc=new Scanner(System.in);
                System.out.println("nombre");
                String opciones=sc.nextLine();
                listaPacientes.stream().filter(c -> c.nombre.equals(opciones)).forEach(c -> System.out.println(c.nombre));
                listaPacientes.stream().filter(c-> c.nombre.charAt(0)== 'D').forEach(c-> System.out.println(c.nombre));
                /*
                listaPacientes.stream().forEach(a-> System.out.println(a.nombre));
                listaPacientes.stream().forEach(a-> listaprueba.add(a.nombre));
                listaprueba.stream().forEach(b-> System.out.println(b));*/
            /*}
            else if (opcion==8){
                miClinica.grabarClase();
            }
            else if (opcion==9){
                miClinica.CargarClase();
            }
            else if (opcion==10){
                miClinica.CargarRepe();
            }
            opcion=menu();


        }


    }*/

    public void CargarRepe() throws IOException {
        FileWriter file=new FileWriter("C:\\fichero\\repes.txt");
        BufferedWriter buffer=new BufferedWriter(file);
        listaprueba.stream().forEach(contendor -> {
            try {
                buffer.write(contendor);
                buffer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buffer.close();
    }

    public void CargarClase() throws IOException, ClassNotFoundException{
        ObjectInputStream file=new ObjectInputStream(new FileInputStream("C:\\fichero\\clinica"));
        Object contenedor;
        contenedor = (Object) file.readObject();
        Paciente Aux;

            try {
                while (true){
                    if (contenedor instanceof Paciente){
                        Aux=(Paciente)contenedor;
                        listaPacientes.add(Aux);
                    }
                    contenedor = (Object) file.readObject();
                }
            }catch (EOFException a){}




    }

    public void grabarClase() throws IOException {
        ObjectOutputStream clase= new ObjectOutputStream(new FileOutputStream("C:\\fichero\\clinica"));
        iterador=listaPacientes.iterator();
        Paciente contenedor;
        while (iterador.hasNext()){
            contenedor=iterador.next();
            clase.writeObject(contenedor);
        }
    }

    public void cargarlista() throws IOException {
        for (String nombrePaciente : CargarDatos()){
            Paciente paciente=new Paciente(nombrePaciente);
            listaPacientes.add(paciente);
        }



    }

    private ArrayList<String> CargarDatos() throws IOException {
        FileReader file=new FileReader("C:\\fichero\\pacientes.txt");
        BufferedReader buffer=new BufferedReader(file);
        ArrayList<String>fichero=new ArrayList<>();

        String aux=buffer.readLine();
        while (aux!=null){
            fichero.add(aux);
            aux=buffer.readLine();
        }
         return fichero;
    }

    public void guardar() throws IOException {
        FileWriter file= new FileWriter("C:\\fichero\\pacientes.txt");
        BufferedWriter buffer= new BufferedWriter(file);
        iterador=listaPacientes.iterator();
        Paciente contenedor;
        while (iterador.hasNext()){
            contenedor=iterador.next();
            buffer.write(contenedor.nombre);
            buffer.newLine();
        }
        buffer.close();

    }

    public void borrar() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nombre de persona para borrar");
        String opcion=sc.nextLine();
        Paciente pAux;
        iterador=listaPacientes.iterator();
        while (iterador.hasNext()){
            pAux=iterador.next();
            if (opcion.equals(pAux.nombre)){
                iterador.remove();
                System.out.println("Paciente eliminado");
                break;
            }
            else{
                System.out.println("el paciente no se encuentra en la lista");
            }
        }
    }

    public void total() {
        System.out.println("El numero de pacientes es " +listaPacientes.size());
        //System.out.println(listaPacientes.stream().count());
    }

    public void VerPacientes() {
        listaPacientes.stream().forEach(pacientes-> System.out.println(pacientes.nombre));
        /*for (Paciente pacientes : listaPacientes){
            System.out.println(pacientes.nombre);
        }*/
    }

    public void registrar(Paciente nuevoPaciente){
        try {
            if (!listaPacientes.add(nuevoPaciente)){
                throw new Excepciones(nuevoPaciente.nombre);
            }
        }
        catch (Excepciones e){
            System.out.println(e.getMessage());
        }
    }

    private static int menu() {
        Scanner sc=new Scanner(System.in);
        System.out.println("- 1 Nuevo paciente \n - 2 Ver pacientes \n - 3 Eliminar paciente \n - 4 Numero de pacientes"+
        "\n - 5 Guardar en texto \n - 6 Cargar texto \n - 8 Grabar coleccion" );
        int opcion=Integer.parseInt(sc.nextLine());
        return opcion;
    }
}
