package com.example.helloworld.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.R;

import java.util.List;

public class PalabraAdapter extends RecyclerView.Adapter<PalabraAdapter.PalabraViewHolder> {

    List<String> palabras;

    public PalabraAdapter(List<String> palabras) {
        this.palabras = palabras;
    }

    @Override
    public PalabraViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //creamos una mini vista utilizando el layout item_palabra
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_palabra, parent, false);

        return new PalabraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PalabraAdapter.PalabraViewHolder holder, int position) { //todo esto se repetira acorde a la cantidad de elementos de la lista
        View view = holder.itemView;

        String palabra = palabras.get(position); //se obtiene el elemento de la lista

        TextView tvPalabra = view.findViewById(R.id.tvPalabra);
        tvPalabra.setText(palabra);

    }

    @Override
    public int getItemCount() {
        return palabras.size();
    }

    public class PalabraViewHolder extends RecyclerView.ViewHolder{

        public PalabraViewHolder(View itemView) {
            super(itemView);
        }
    }

}
