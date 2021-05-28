package com.example.helloworld.entities;

public class Contacto {
    public String Nombre;
    public String Numero;
    public String Email;
    public String Direccion;

    public Contacto(String nombre, String numero) {
        this.Nombre = nombre;
        this.Numero = numero;
    }

    public Contacto(String nombre, String numero, String email, String direccion){
        this.Nombre = nombre;
        this.Numero = numero;
        this.Email = email;
        this.Direccion = direccion;
    }
}
