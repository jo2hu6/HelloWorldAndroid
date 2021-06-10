package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.helloworld.adapters.AnimeAdapter;
import com.example.helloworld.adapters.FrutaAdapter;
import com.example.helloworld.entities.Anime;
import com.example.helloworld.entities.Fruta;
import com.example.helloworld.services.AnimeService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_list);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnimeService service = retrofit.create(AnimeService.class);
        Call<List<Anime>> animes = service.getAll();

        animes.enqueue(new Callback<List<Anime>>() {
            @Override
            public void onResponse(Call<List<Anime>> call, Response<List<Anime>> response) {
                List<Anime> a = response.body();
                RecyclerView rv = findViewById(R.id.rvAnimes);
                rv.setLayoutManager(new LinearLayoutManager(AnimeListActivity.this));
                AnimeAdapter adapter = new AnimeAdapter(a);
                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Anime>> call, Throwable t) {

            }
        });

    }

}