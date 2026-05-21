package puj.edu.co.Preparcial.model;

import puj.edu.co.Preparcial.excepciones.Pasajero_Existente;
import puj.edu.co.Preparcial.excepciones.Vuelo_no_encontrado;

import java.time.LocalDate;
import java.util.ArrayList;

public class Aerolinea {

    private String nombre;
    private ArrayList<Vuelo> vuelos;

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



}

