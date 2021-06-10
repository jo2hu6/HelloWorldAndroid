package com.example.helloworld.entities;

public class Fruta {

    public int id;
    public String codigo;
    public String nombre;
    public String vitaminas;
    public boolean me_gusta;

    public Fruta(String nombre, String vitaminas) {
        this.nombre = nombre;
        this.vitaminas = vitaminas;
    }

    public Fruta(int id, String nombre, boolean like) {
        this.id = id;
        this.nombre = nombre;
        this.me_gusta = like;
    }

    public Fruta(int id, String codigo,String nombre, String vitaminas, boolean like) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.vitaminas = vitaminas;
        this.me_gusta = like;
    }
}
