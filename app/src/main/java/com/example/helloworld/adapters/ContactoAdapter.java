package com.example.helloworld.adapters;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.R;
import com.example.helloworld.entities.Contacto;

import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>{

    List<Contacto> contactos;

    public ContactoAdapter(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //creamos una mini vista utilizando el layout item_contacto
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacto, parent, false);

        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactoAdapter.ContactoViewHolder holder, int position) { //todo esto se repetira acorde a la cantidad de elementos de la lista
        View view = holder.itemView;

        Contacto contacto = contactos.get(position); //se obtiene el elemento de la lista

//        TextView tvPalabra = view.findViewById(R.id.tvPalabra);
//        tvPalabra.setText(contacto);

        TextView tvNombre = view.findViewById(R.id.tvNombre);
        TextView tvNumero = view.findViewById(R.id.tvNumero);
        Button btnSMS = view.findViewById(R.id.btnSMS);

        tvNombre.setText(contacto.Nombre);
        tvNumero.setText(contacto.Numero);

        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("main_app","Abriendo SMS: " + contacto.Numero);
                Bundle bundle = new Bundle();
                Uri uri = Uri.parse("cel: "+contacto.Numero);
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("Mensaje de texto","");
                startActivity(view.getContext(), intent, bundle); //ERROR!!

            }
        });

    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder{

        public ContactoViewHolder(View itemView) {
            super(itemView);
        }
    }

}
