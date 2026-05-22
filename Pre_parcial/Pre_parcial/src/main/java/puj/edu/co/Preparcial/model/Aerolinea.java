package puj.edu.co.Preparcial.model;

import puj.edu.co.Preparcial.excepciones.Pasajero_Existente;
import puj.edu.co.Preparcial.excepciones.Vuelo_no_encontrado;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Aerolinea implements Serializable {

    private String nombre;
    private ArrayList<Vuelo> vuelos;

    public Aerolinea(String nombre) {
        this.nombre = nombre;
        this.vuelos = new ArrayList<>();
    }

    // METODOS

    public Vuelo buscar_vuelo(int num_vuelo){
        for(Vuelo vuelo : vuelos){
            if(vuelo.getNumero_vuelo() == num_vuelo){
                return vuelo;
            }
        }
        return null;
    }


    public void agregar_pasajero(int numero_vuelo, String nombre, int id, LocalDate fecha_nacimiento, int numero_silla){
        if(buscar_vuelo(numero_vuelo) != null){
            ArrayList<Pasajero> pasajeros_arr = buscar_vuelo(numero_vuelo).getPasajeros();
            for(Pasajero pasajero : pasajeros_arr){
                if(pasajero.getNombre().equals(nombre)){
                    throw new Pasajero_Existente();
                }
            }
            Pasajero pasajero_1 = new Pasajero(nombre,id,fecha_nacimiento,numero_silla);
            pasajeros_arr.add(pasajero_1);
        }
        else{
            throw new Vuelo_no_encontrado();
        }
    }

    public ArrayList<String> vuelos_con_condiciones(String condicion){
        ArrayList<String> lista_vuelos = new ArrayList<>();
        for(Vuelo vuelo:vuelos){
            if(vuelo instanceof Internacional){
                Internacional internacional = (Internacional) vuelo;
                ArrayList<Requisitos_Migratorios> requisitos = internacional.getRequisitos();
                for(Requisitos_Migratorios requisito : requisitos){
                    if(requisito.getDescripcion().equals(condicion)){
                        lista_vuelos.add(nombre + "-" + internacional.getNumero_vuelo() + "-" + internacional.getOrigen() + "-" + internacional.getDestino());
                    }
                }
            }
        }
        return lista_vuelos;
    }

    public void generar_reporte(String origen){
        String archivo = "vuelos_origen.txt";
        for(Vuelo vuelo : vuelos){
            if(vuelo.getOrigen().equalsIgnoreCase(origen)){
                if(vuelo instanceof Nacional) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                    Nacional n = (Nacional) vuelo;
                        writer.write("Nacional" + "-");
                        writer.write(this.nombre + "-");
                        writer.write(n.getNumero_vuelo() + "-");
                        writer.write(n.getOrigen() + "-");
                        writer.write(n.getDestino() + "-");
                        writer.write(n.getFecha_inicial() + "-");
                        writer.write(n.getFecha_final() + "-");
                        writer.write(n.getValor() + "-");
                        writer.write(n.getTipo_aeropuerto() +"\n");
                        System.out.println("Vuelos guardados como texto en " + archivo);
                    } catch (IOException e) {
                        System.out.println("Error al escribir en texto: " + e.getMessage());
                    }
                }
                else{
                    Internacional I = (Internacional) vuelo;
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                        writer.write("Internacional" + "-");
                        writer.write(this.nombre + "-");
                        writer.write(I.getNumero_vuelo() + "-");
                        writer.write(I.getOrigen() + "-");
                        writer.write(I.getDestino() + "-");
                        writer.write(I.getFecha_inicial() + "-");
                        writer.write(I.getFecha_inicial() + "-");
                        writer.write(I.getValor() + "-");
                        writer.write(I.getImpuesto() +"\n");
                        System.out.println("Vuelos guardados como texto en " + archivo);
                    } catch (IOException e) {
                        System.out.println("Error al escribir en texto: " + e.getMessage());
                    }
                }
            }
        }
    }



}

