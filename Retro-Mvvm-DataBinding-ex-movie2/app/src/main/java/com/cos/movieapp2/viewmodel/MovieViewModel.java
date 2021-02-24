package com.cos.movieapp2.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cos.movieapp2.model.Movie;
import com.cos.movieapp2.model.ResponseDto;
import com.cos.movieapp2.service.MovieService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {
    private static final String TAG = "MovieViewModel";

    private MutableLiveData<List<Movie>> mtMovie = new MutableLiveData<>();

    public MovieViewModel() {
        List<Movie> movies = new ArrayList<>();
        mtMovie.setValue(movies);
    }

    public MutableLiveData<List<Movie>> subscribe() {
        return mtMovie;
    }

    public void findAll() {
        Call<ResponseDto<List<Movie>>> call = MovieService.retrofit.create(MovieService.class).findAll();
        call.enqueue(new Callback<ResponseDto<List<Movie>>>() {
            @Override
            public void onResponse(Call<ResponseDto<List<Movie>>> call, Response<ResponseDto<List<Movie>>> response) {
                ResponseDto<List<Movie>> result = response.body();
                mtMovie.setValue(result.getData());
            }

            @Override
            public void onFailure(Call<ResponseDto<List<Movie>>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
    }

    public void deleteById(final long id) {

        Call<ResponseDto> call =MovieService.retrofit.create(MovieService.class).deleteById(id);
        call.enqueue(new Callback<ResponseDto>() {
            @Override
            public void onResponse(Call<ResponseDto> call, Response<ResponseDto> response) {
                ResponseDto result = response.body();
                if(result.getStatusCode()==1) {
                    List<Movie> movies = mtMovie.getValue();
                    for (int i=0; i<movies.size(); i++) {
                       if(movies.get(i).getId() == id) {
                           movies.remove(i);
                           break;
                       }
                   }
                  mtMovie.setValue(movies);
               } else {
                   Log.d(TAG, "onResponse: 삭제 실패!");
                }
            }

            @Override
            public void onFailure(Call<ResponseDto> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}
