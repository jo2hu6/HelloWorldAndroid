package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.helloworld.entities.Fruta;
import com.example.helloworld.services.FrutaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FrutaFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruta_form);

        EditText edtNombre = findViewById(R.id.edtNombreFruta);
        EditText edtVitaminas = findViewById(R.id.edtVitaminas);
        Button btnSubmit = findViewById(R.id.btnSubmitFruta);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FrutaService service = retrofit.create(FrutaService.class);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = edtNombre.getText().toString();
                String vitaminas = edtVitaminas.getText().toString();

                Fruta fruta = new Fruta(nombre,vitaminas);

                Log.i("app","Este es el nombre: "+nombre);

                if (!nombre.trim().equals("") && !vitaminas.trim().equals("")) //si texto es diferente de vacio
                {
                    Call<Void> contactCall = service.testPost(fruta);
                    contactCall.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            //codigo que recibe al haber esperado el call

                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {

                        }
                    });
                    Intent intent = new Intent(FrutaFormActivity.this, FrutaListActivity.class);
                    startActivity(intent);
                }else{
                    Log.i("main_app","Ingrese nombre");
                    Toast.makeText(FrutaFormActivity.this, "Inserte los datos!", Toast.LENGTH_SHORT).show();//muestra mensaje en pantalla
                }

            }
        });

    }

}