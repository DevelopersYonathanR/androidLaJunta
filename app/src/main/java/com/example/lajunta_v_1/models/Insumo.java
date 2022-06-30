package com.example.lajunta_v_1.models;

public class Insumo {
    private int id;
    private String nombre;
    private int cantidad;
    private String medida;

    public Insumo(int id, String nombre, int cantidad, String medida) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.medida = medida;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
}
