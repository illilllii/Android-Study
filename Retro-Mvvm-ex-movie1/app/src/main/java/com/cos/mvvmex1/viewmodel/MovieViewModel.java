package com.cos.mvvmex1.viewmodel;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.mvvmex1.MainActivity;
import com.cos.mvvmex1.model.Movie;
import com.cos.mvvmex1.service.MovieApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {
    private static final String TAG = "MovieViewModel";
    private MutableLiveData<List<Movie>> mtMovies = new MutableLiveData<>();
    // LiveData, MutableLiveData
    public MutableLiveData<List<Movie>> 구독() {
        return mtMovies;
    }
    MovieApi movieApi = MovieApi.retrofit.create(MovieApi.class);

    public void 데이터등록() {
        Call<List<Movie>> call = movieApi.findAll();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                Log.d(TAG, "onResponse: 통신성공");
                List<Movie> movies = response.body();
                mtMovies.setValue(movies);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.d(TAG, "onFailure: 통신실패");
            }
        });
    }
    public void 데이터삭제(long i) {
        Call<Void> call = movieApi.deleteById(i);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d(TAG, "onResponse: 삭제통신성공");
                if(response.isSuccessful()) {
                    Log.d(TAG, "onResponse: 삭제성공");
                    데이터등록();
                } else {
                    Log.d(TAG, "onResponse: 삭제실패");
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d(TAG, "onFailure: 삭제통신실패");
            }
        });

    }
    public void 데이터초기화() {
        List<Movie> posts = new ArrayList<>();
        mtMovies.setValue(posts);
    }

}
