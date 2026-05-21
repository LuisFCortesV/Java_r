package puj.edu.co.Preparcial.excepciones;

public class Vuelo_no_encontrado extends RuntimeException {
    public Vuelo_no_encontrado() {
        super("El vuelo no fue encontrado, ingrese uno que si este registrado.");
    }
}
