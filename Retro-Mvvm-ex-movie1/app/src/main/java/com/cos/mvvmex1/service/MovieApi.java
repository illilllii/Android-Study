package com.cos.mvvmex1.service;

import com.cos.mvvmex1.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieApi {
    //http://localhost:8000/api/movie

    @GET("/api/movie")
    Call<List<Movie>> findAll();

    @DELETE("/api/movie/{id}")
    Call<Void> deleteById(@Path("id") long id);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
