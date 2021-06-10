package com.example.helloworld.adapters;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.DetailContactActivity;
import com.example.helloworld.R;
import com.example.helloworld.entities.Contacto;

import java.util.List;

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
        ImageView iv = view.findViewById(R.id.imgOvni);

        iv.setImageResource(R.drawable.images);
        tvNombre.setText(contacto.Nombre);
        tvNumero.setText(contacto.Numero);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("main_app","Abriendo SMS: " + contacto.Numero);
                /*Uri uri = Uri.parse("cel: ");
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("Mensaje de texto","Mensajeeee"); //ERROR!!
                view.getContext().startActivity(intent);*/

                Intent intent = new Intent(view.getContext(), DetailContactActivity.class);
                intent.putExtra("nombre", contacto.Nombre);
                intent.putExtra("numero", contacto.Numero);
                intent.putExtra("email", contacto.Email);
                intent.putExtra("direccion", contacto.Direccion);
                view.getContext().startActivity(intent);

            }
        });

    }


    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        public ContactoViewHolder(View itemView) {
            super(itemView);
        }
    }

}
