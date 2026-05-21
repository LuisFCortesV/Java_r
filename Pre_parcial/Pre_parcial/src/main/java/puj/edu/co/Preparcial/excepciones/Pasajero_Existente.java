package puj.edu.co.Preparcial.excepciones;

public class Pasajero_Existente extends RuntimeException {
    public Pasajero_Existente() {
        super("Este pasajero ya existe, agregue uno que no lo este");
    }
}
