package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_detail);

        getIncomingIntent();

    }

    private void getIncomingIntent()
    {
        if(getIntent().hasExtra("nombre")&&getIntent().hasExtra("numero")&&getIntent().hasExtra("email")&&getIntent().hasExtra("direccion"))
        {
            String nombre = getIntent().getStringExtra("nombre");
            String numero = getIntent().getStringExtra("numero");
            String email = getIntent().getStringExtra("email");
            String direccion = getIntent().getStringExtra("direccion");

            TextView tvName = findViewById(R.id.nameContact);
            TextView tvNumber = findViewById(R.id.numberContact);
            TextView tvEmail = findViewById(R.id.emailContact);
            TextView tvAddress = findViewById(R.id.addressContact);

            tvName.setText(nombre);
            tvNumber.setText(numero);
            tvEmail.setText(email);
            tvAddress.setText(direccion);

        }
    }

}