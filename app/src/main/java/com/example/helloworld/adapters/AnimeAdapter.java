package com.example.helloworld.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.helloworld.R;
import com.example.helloworld.entities.Anime;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>{

    List<Anime> animes;

    public AnimeAdapter(List<Anime> animes) {this.animes = animes;}

    @Override
    public AnimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anime, parent, false);
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnimeAdapter.AnimeViewHolder holder, int position) {

        View view = holder.itemView;
        Anime anime = animes.get(position);

        ImageView ivAnime = view.findViewById(R.id.imgAnime);
        TextView tvNombre = view.findViewById(R.id.tvNombreAnime);
        TextView tvDescripcion = view.findViewById(R.id.tvDescripcionAnime);

        Glide.with(view).asBitmap().load(anime.image).override(200,200).transform(new CircleCrop()).into(ivAnime);
        tvNombre.setText(anime.nombre);
        tvDescripcion.setText(anime.descripcion);

    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public static class AnimeViewHolder extends RecyclerView.ViewHolder{
        public AnimeViewHolder(View itemView) { super(itemView); }
    }

}
