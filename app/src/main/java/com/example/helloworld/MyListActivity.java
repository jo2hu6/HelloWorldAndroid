package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.helloworld.entities.Contacto;
import com.example.helloworld.services.ContactService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://webhook.site/") //https://run.mocky.io/
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ContactService service = retrofit.create(ContactService.class); // instanciar servicio

        // Call<Void> contactsCall = service.testGet("Josue", "Rivera");//llamar metodo del servicio que retorna un Call

        Contacto contacto = new Contacto("Josue", "99999");
        Call<Void> contactsCall = service.testPostVoid(contacto);

        contactsCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                //codigo que recibe al haber esperado el call
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });

        /*List<Contacto> contactos = response.body();

        RecyclerView rv = findViewById(R.id.rvPalabras);
        rv.setLayoutManager(new LinearLayoutManager(MyListActivity.this));//es obligatorio

        ContactoAdapter adapter = new ContactoAdapter(contactos);
        rv.setAdapter(adapter);*/

    }

    private List<Contacto> GetContactos() {
        List<Contacto> contactos = new ArrayList<>();

        contactos.add(new Contacto("Hola","11111", "11111", "1111111"));
        contactos.add(new Contacto("Hola2","222222", "gmail", "222222"));
        contactos.add(new Contacto("Hola3","33333", "33333", "33333"));
        contactos.add(new Contacto("Hola4","44444", "44444", "44444"));
        contactos.add(new Contacto("Hola5","55555", "55555", "55555"));
        contactos.add(new Contacto("Hola6","666666", "666666", "666666"));

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