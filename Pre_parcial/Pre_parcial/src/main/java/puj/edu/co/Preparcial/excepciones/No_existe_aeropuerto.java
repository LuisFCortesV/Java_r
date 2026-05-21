package puj.edu.co.Preparcial.excepciones;

public class No_existe_aeropuerto extends RuntimeException {
    public No_existe_aeropuerto() {
        super("No existe ese aeropuerto");
    }
}
