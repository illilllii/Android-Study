package com.cos.movieapp2.service;

import com.cos.movieapp2.model.Movie;
import com.cos.movieapp2.model.ResponseDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieService {

    @GET("api/movie")
    //Call<List<Movie>> findAll();
    Call<ResponseDto<List<Movie>>> findAll();

    @DELETE("api/movie/{id}")
    Call<ResponseDto> deleteById(@Path("id") long id);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.137.33:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
