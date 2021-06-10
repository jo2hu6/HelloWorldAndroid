package com.example.helloworld.entities;

import java.util.Date;

public class Anime {

    public int id;
    public String nombre;
    public String descripcion;
    public String image;
    public Date created_at;
    public Date updated_at;

    public Anime(String nombre, String descripcion, String image) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.image = image;
    }

    public Anime(int id, String nombre, String descripcion, String image) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.image = image;
    }

    public Anime(int id, String nombre, String descripcion, String image, Date created_at, Date updated_at) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.image = image;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
