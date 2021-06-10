package com.example.helloworld.services;

import com.example.helloworld.entities.Anime;
import com.example.helloworld.entities.Fruta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AnimeService {

    @GET("animes")
    Call<List<Anime>> getAll();

    @POST("animes")
    Call<Void> testPost(@Body Anime anime);

}
