package com.cos.mvvmex1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;

import com.cos.mvvmex1.adapter.MovieAdapter;
import com.cos.mvvmex1.model.Movie;
import com.cos.mvvmex1.service.MovieApi;
import com.cos.mvvmex1.viewmodel.MovieViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private MovieViewModel movieViewModel;

    private RecyclerView rvMovie;
    private MovieAdapter movieAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setSupportActionBar(toolbar);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        rvMovie.setLayoutManager(linearLayoutManager);
        rvMovie.setAdapter(movieAdapter);

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                movieViewModel.데이터삭제(movieAdapter.getMovieId(viewHolder.getAdapterPosition()));

            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rvMovie);

        movieViewModel.구독().observe(this, movies -> {
            Log.d(TAG, "onCreate: 데이터변경됨");
            movieAdapter.setMovies(movies);
        });
        movieViewModel.데이터등록();

    }
    private void init() {
        toolbar = findViewById(R.id.toolbar);
        rvMovie = findViewById(R.id.rv_movie);
        movieAdapter = new MovieAdapter();
        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);

    }


}