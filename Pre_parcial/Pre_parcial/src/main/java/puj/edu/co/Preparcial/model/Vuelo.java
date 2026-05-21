package puj.edu.co.Preparcial.model;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Vuelo {
    private String origen;
    private String destino;
    private LocalDate fecha_inicial;
    private LocalDate fecha_final;
    private int numero_vuelo;
    private int valor;

    private ArrayList<Pasajero> pasajeros;

    public Vuelo(String origen, String destino, LocalDate fecha_inicial, LocalDate fecha_final, int numero_vuelo, int valor, ArrayList<Pasajero> pasajeros) {
        this.origen = origen;
        this.destino = destino;
        this.fecha_inicial = fecha_inicial;
        this.fecha_final = fecha_final;
        this.numero_vuelo = numero_vuelo;
        this.valor = valor;
        this.pasajeros = pasajeros;
    }

    // Metodos

    public abstract float calcular_valor();

    public Pasajero buscar_pasajero(String nombre){
        for(Pasajero pasajero : pasajeros){
            if(pasajero.getNombre().equals(nombre)){
                return pasajero;
            }
        }
        return null;
    }

    public void eliminar_pasajeros_menores_de_edad(){
        ArrayList<Pasajero> menores = new ArrayList<>();
        for(Pasajero pasajero : pasajeros){
            if(pasajero.calcular_edad(pasajero.getFecha_nacimiento()) < 18){
                menores.add(pasajero);
            }
        }
        pasajeros.removeAll(menores);
    }



    // GETTER - SETTER


    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFecha_inicial() {
        return fecha_inicial;
    }

    public void setFecha_inicial(LocalDate fecha_inicial) {
        this.fecha_inicial = fecha_inicial;
    }

    public LocalDate getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(LocalDate fecha_final) {
        this.fecha_final = fecha_final;
    }

    public int getNumero_vuelo() {
        return numero_vuelo;
    }

    public void setNumero_vuelo(int numero_vuelo) {
        this.numero_vuelo = numero_vuelo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(ArrayList<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }
}
