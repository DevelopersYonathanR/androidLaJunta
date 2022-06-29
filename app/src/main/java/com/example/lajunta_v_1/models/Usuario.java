package com.example.lajunta_v_1.models;

public class Usuario {
    private int id;
    private String username;
    private String password;
    private int id_cargo;

    public Usuario(int id, String username, String password, int id_cargo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.id_cargo = id_cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }
}
