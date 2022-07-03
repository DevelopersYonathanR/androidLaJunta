package com.example.lajunta_v_1.models;

public class Habitacion {

    private int id;
    private String nombre;
    private int num_personas;
    private double costo_persona;


    public Habitacion(int id, String nombre, int num_personas, double costo_persona) {
        this.id = id;
        this.nombre = nombre;
        this.num_personas = num_personas;
        this.costo_persona = costo_persona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNum_personas() {
        return num_personas;
    }

    public void setNum_personas(int num_personas) {
        this.num_personas = num_personas;
    }

    public double getCosto_persona() {
        return costo_persona;
    }

    public void setCosto_persona(double costo_persona) {
        this.costo_persona = costo_persona;
    }
}
