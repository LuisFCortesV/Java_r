package puj.edu.co.Preparcial.app;

import puj.edu.co.Preparcial.model.Aerolinea;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class App
{
    private Aerolinea aerolinea;

    public static void main( String[] args )
    {
        App app = new App();
        app.aerolinea = new Aerolinea("Avianca");
        app.guardar_aerolinea();
    }

    public void guardar_aerolinea() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("aerolinea.dat"))) {
            oos.writeObject(this.aerolinea);
            System.out.println("Objeto Persona serializado correctamente en " + "aerolinea.dat");
        } catch (IOException e) {
            System.out.println("Error al serializar: " + e.getMessage());
        }
    }

}
