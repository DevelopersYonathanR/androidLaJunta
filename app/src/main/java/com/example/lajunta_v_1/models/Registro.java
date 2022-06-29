package com.example.lajunta_v_1.models;

import java.util.Date;

public class Registro {
    private int id;
    private String nombre, apellido;
   private int id_habitacion;
   private Date fecha_inicio, fecha_termino;
   private String correo;
    private String telefono, telefono_2;
    private double costo_diario, costo_total;

    public Registro(int id, String nombre, String apellido, int id_habitacion, Date fecha_inicio, Date fecha_termino, String correo, String telefono, String telefono_2, double costo_diario, double costo_total) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_habitacion = id_habitacion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.correo = correo;
        this.telefono = telefono;
        this.telefono_2 = telefono_2;
        this.costo_diario = costo_diario;
        this.costo_total = costo_total;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(Date fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono_2() {
        return telefono_2;
    }

    public void setTelefono_2(String telefono_2) {
        this.telefono_2 = telefono_2;
    }

    public double getCosto_diario() {
        return costo_diario;
    }

    public void setCosto_diario(double costo_diario) {
        this.costo_diario = costo_diario;
    }

    public double getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(double costo_total) {
        this.costo_total = costo_total;
    }
}
