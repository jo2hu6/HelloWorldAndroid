package com.example.helloworld.services;
import com.example.helloworld.entities.Fruta;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FrutaService {

    @GET("N00031931/frutas")
    Call<List<Fruta>> getAll();

    @POST("N00031931/frutas/crear")
    Call<Void> testPost(@Body Fruta fruta);

}
