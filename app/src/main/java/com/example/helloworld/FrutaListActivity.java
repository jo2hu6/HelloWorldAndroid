package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.helloworld.adapters.FrutaAdapter;
import com.example.helloworld.entities.Fruta;
import com.example.helloworld.services.FrutaService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FrutaListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruta_list);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/") //https://run.mocky.io/
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FrutaService service = retrofit.create(FrutaService.class);
        Call<List<Fruta>> frutas = service.getAll();

        frutas.enqueue(new Callback<List<Fruta>>() {
            @Override
            public void onResponse(Call<List<Fruta>> call, Response<List<Fruta>> response) {
                List<Fruta> f = response.body();
                RecyclerView rv = findViewById(R.id.rvFrutas);
                rv.setLayoutManager(new LinearLayoutManager(FrutaListActivity.this));

                FrutaAdapter adapter = new FrutaAdapter(f);
                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Fruta>> call, Throwable t) {

            }
        });



    }

}