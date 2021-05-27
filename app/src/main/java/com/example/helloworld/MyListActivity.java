package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.helloworld.adapters.ContactoAdapter;
import com.example.helloworld.adapters.PalabraAdapter;
import com.example.helloworld.entities.Contacto;

import java.util.ArrayList;
import java.util.List;

public class MyListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        RecyclerView rv = findViewById(R.id.rvPalabras);
        rv.setLayoutManager(new LinearLayoutManager(MyListActivity.this));//es obligatorio

        List<Contacto> contactos = GetContactos();

        ContactoAdapter adapter = new ContactoAdapter(contactos);
        rv.setAdapter(adapter);

    }

    private List<Contacto> GetContactos() {
        List<Contacto> contactos = new ArrayList<>();

        contactos.add(new Contacto("Hola","11111"));
        contactos.add(new Contacto("Hola2","222222"));
        contactos.add(new Contacto("Hola3","33333"));
        contactos.add(new Contacto("Hola4","44444"));
        contactos.add(new Contacto("Hola5","55555"));
        contactos.add(new Contacto("Hola6","666666"));

        return contactos;
    }

    public List<String> GetPalabras()
    {
        List<String> palabras = new ArrayList<>();
        palabras.add("Palabra 1");
        palabras.add("Palabra 2");
        palabras.add("Palabra 3");
        palabras.add("Palabra 4");
        palabras.add("Palabra 5");
        palabras.add("Palabra 6");
        palabras.add("Palabra 7");

        return palabras;
    }

}