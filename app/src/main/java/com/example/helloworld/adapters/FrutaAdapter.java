package com.example.helloworld.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.helloworld.R;
import com.example.helloworld.entities.Fruta;
import java.util.List;

public class FrutaAdapter extends RecyclerView.Adapter<FrutaAdapter.FrutaViewHolder> {

    List<Fruta> frutas;

    public FrutaAdapter(List<Fruta> frutas) { this.frutas = frutas; }

    @Override
    public FrutaViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fruta, parent, false);
        return new FrutaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FrutaAdapter.FrutaViewHolder holder, int position) {
        View view = holder.itemView;
        Fruta fruta = frutas.get(position);

        ImageView ivFruta = view.findViewById(R.id.imgFruta);
        TextView tvNombre = view.findViewById(R.id.tvNombreFruta);
        TextView tvVitaminas = view.findViewById(R.id.tvVitaminasFruta);

        ivFruta.setImageResource(R.drawable.maxresdefault);
        tvNombre.setText(fruta.nombre);
        tvVitaminas.setText(fruta.vitaminas);

    }

    @Override
    public int getItemCount() {
        return frutas.size();
    }

    public static class FrutaViewHolder extends RecyclerView.ViewHolder{
        public FrutaViewHolder(View itemView) { super(itemView); }
    }

}
