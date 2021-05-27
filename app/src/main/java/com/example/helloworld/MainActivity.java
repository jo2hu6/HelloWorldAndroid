package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   /* class MyClaseClick implements View.OnClickListener {
        @Override
        public void onClick(View v){
            Log.i("main_app", "hice click en el boton");
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnClick);

        /*View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("main_app", "hice click en el boton");
                tv.setText("Hola Josue!");
            }
        };*/

        

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtName = findViewById(R.id.edtName);
                String texto = edtName.getText().toString();
                Log.i("main","El texto es: "+texto);

                //llamar a otra actividad
                //Context context = getApplicationContext();
                //Context context = MainActivity.this; //lo mismo que lo de arriba

                if (!texto.trim().equals("")) //si texto es diferente de vacio
                {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("NAME_EXTRA",texto);
                    startActivity(intent);
                }else{
                    Log.i("main_app","Ingrese nombre");
                    Toast.makeText(MainActivity.this, "Inserte nombre", Toast.LENGTH_LONG).show();//muestra mensaje en pantalla
                }

            }
        });

       // btn.setOnClickListener(o -> {Log.i("main_app", "hice click en el boton");});
        //ES LO MISMO QUE EL EL EVENTO DE ARRIBA, PERO SE UTILIZA CUANDO LA INTERFAZ TIENE SOLO UN METODO

    }
}