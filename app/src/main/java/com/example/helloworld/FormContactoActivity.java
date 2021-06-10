package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.helloworld.entities.Contacto;
import com.example.helloworld.services.ContactService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormContactoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_contacto);

        Button btnSubmit = findViewById(R.id.btnSubmitForm);
        EditText edtNombre = findViewById(R.id.edtNombre);
        EditText edtNumero = findViewById(R.id.edtNumero);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://webhook.site/") //https://run.mocky.io/
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ContactService service = retrofit.create(ContactService.class); // instanciar servicio

        //Call<Void> contactsCall = service.testGet("Josue", "Rivera");//llamar metodo del servicio que retorna un Call



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edtNombre.getText().toString();
                String number = edtNumero.getText().toString();
                Contacto contacto = new Contacto(name,number);
                Call<Void> contactCall = service.testPostVoid(contacto);
                Log.i("app","Este es el nombre: "+name);

                contactCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        //codigo que recibe al haber esperado el call

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });

            }
        });

    }

}