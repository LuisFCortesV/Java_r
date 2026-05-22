package puj.edu.co.Preparcial.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Internacional extends Vuelo{
    private int impuesto;
    private ArrayList<Requisitos_Migratorios> requisitos;

    public Internacional(String origen, String destino, LocalDate fecha_inicial, LocalDate fecha_final, int numero_vuelo, int valor, ArrayList<Pasajero> pasajeros, int impuesto, ArrayList<Requisitos_Migratorios> requisitos) {
        super(origen, destino, fecha_inicial, fecha_final, numero_vuelo, valor);
        this.impuesto = impuesto;
        this.requisitos = requisitos;
    }

    public float calcular_valor(){
        return getValor() + (getValor() * (impuesto / 100.0f));
    }
    
    // GETTER AND SETTER

    public int getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }

    public ArrayList<Requisitos_Migratorios> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(ArrayList<Requisitos_Migratorios> requisitos) {
        this.requisitos = requisitos;
    }
}
