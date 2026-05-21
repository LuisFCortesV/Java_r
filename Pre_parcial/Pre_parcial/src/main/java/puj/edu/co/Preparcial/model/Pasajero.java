package puj.edu.co.Preparcial.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pasajero {
    private String nombre;
    private int ind;
    private LocalDate fecha_nacimiento;
    private int num_sillas;

    // CONSTRUCTOR

    public Pasajero(String nombre, int ind, LocalDate fecha_nacimiento, int num_sillas) {
        this.nombre = nombre;
        this.ind = ind;
        this.fecha_nacimiento = fecha_nacimiento;
        this.num_sillas = num_sillas;
    }

    // METODOS

    public static LocalDate obtenerFechaActual() {
        return LocalDate.now();
    }

    public int calcular_edad(LocalDate fecha_nacimiento) {
        return (int) ChronoUnit.YEARS.between(fecha_nacimiento, obtenerFechaActual());
    }





    // GETTER AND SETTER

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getInd() {
        return ind;
    }

    public void setInd(int ind) {
        this.ind = ind;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getNum_sillas() {
        return num_sillas;
    }

    public void setNum_sillas(int num_sillas) {
        this.num_sillas = num_sillas;
    }
}
