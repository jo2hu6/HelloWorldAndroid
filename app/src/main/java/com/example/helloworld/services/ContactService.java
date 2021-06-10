package com.example.helloworld.services;

import com.example.helloworld.entities.Contacto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ContactService {

    @GET("v3/727befa7-e552-4da7-90f6-ba1ba46209f3")
    Call<List<Contacto>> getAll();

    @GET("d84c6f93-2e6b-4bfc-95c7-5d6755645e6f")
    Call<Void> testGet(@Query("name") String name, @Query("lastname") String lastname);

    @POST("d84c6f93-2e6b-4bfc-95c7-5d6755645e6f")
    Call<Contacto> testPost(@Body Contacto contacto);

    @POST("d84c6f93-2e6b-4bfc-95c7-5d6755645e6f")
    Call<Void> testPostVoid(@Body Contacto contacto);

}
