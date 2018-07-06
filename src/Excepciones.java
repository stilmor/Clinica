public class Excepciones extends Exception {
    String nombre;
    public Excepciones(String nombre) {

        this.nombre=nombre;
        Clinica repe=new Clinica();
        repe.repetidos(nombre);
    }

    @Override
    public String getMessage() {
        return "El paciente ya esta registrado";
    }
}
