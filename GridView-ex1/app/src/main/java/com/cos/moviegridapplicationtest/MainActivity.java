package com.cos.moviegridapplicationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private GridView mGvMovie;
    private List<Movie> movies;
    private MovieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        adapter = new MovieAdapter(movies);
        mGvMovie.setAdapter(adapter);
    }

    private void init() {
        mGvMovie = findViewById(R.id.gv_movie);
        movies = new ArrayList<>();
        download();

    }

    private void download() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 스레드로 돌아야함.
                movies.add(new Movie(1, "써니", R.drawable.mov01));
                movies.add(new Movie(2, "완득이", R.drawable.mov02));
                movies.add(new Movie(3, "괴물", R.drawable.mov03));
                movies.add(new Movie(4, "라디오스타", R.drawable.mov04));
                movies.add(new Movie(5, "비열한거리", R.drawable.mov05));
                movies.add(new Movie(6, "왕의 남자", R.drawable.mov06));
                movies.add(new Movie(7, "아일랜드", R.drawable.mov07));
                movies.add(new Movie(8, "웰컴투동막골", R.drawable.mov08));
                movies.add(new Movie(9, "헬보이", R.drawable.mov09));
                movies.add(new Movie(10, "백투더퓨처", R.drawable.mov10));
                movies.add(new Movie(11, "여인의향기", R.drawable.mov11));
                movies.add(new Movie(12, "쥬라기공원", R.drawable.mov12));

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();


    }
}