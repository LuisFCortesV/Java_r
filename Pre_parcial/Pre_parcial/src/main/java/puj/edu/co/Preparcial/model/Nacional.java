package puj.edu.co.Preparcial.model;

import puj.edu.co.Preparcial.excepciones.No_existe_aeropuerto;

import java.time.LocalDate;
import java.util.ArrayList;

public class Nacional extends Vuelo{

    private String tipo_aeropuerto;

    public Nacional(String tipo_aeropuerto, String origen, String destino, LocalDate fecha_inicial, LocalDate fecha_final, int numero_vuelo, int valor, ArrayList<Pasajero> pasajeros) {
        super(origen,destino,fecha_inicial,fecha_final,numero_vuelo,valor,pasajeros);
        this.tipo_aeropuerto = tipo_aeropuerto;
    }

    @Override
    public float calcular_valor(){
        try {
            if (tipo_aeropuerto.equalsIgnoreCase("Grande")) {
                return (float) (getValor() + (getValor() * 0.2));
            } else if (tipo_aeropuerto.equalsIgnoreCase("Mediano")) {
                return (float) (getValor() + (getValor() * 0.1));
            } else if (tipo_aeropuerto.equalsIgnoreCase("Pequeño")) {
                return (float) (getValor() + (getValor() * 0.05));
            } else {
                throw new No_existe_aeropuerto();
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }



}
