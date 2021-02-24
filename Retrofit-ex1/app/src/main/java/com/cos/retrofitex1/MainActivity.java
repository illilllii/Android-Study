package com.cos.retrofitex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";

    private RecyclerView rvPost;
    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        download();


    }


    private void init() {
        rvPost = findViewById(R.id.rv_post);
        postAdapter = new PostAdapter();

        rvPost.setAdapter(postAdapter);

    }
    private void download() {
        PostApi postApi = PostApi.retrofit.create(PostApi.class);

        // https://jsonplaceholder.typicode.com
        Call<List<Post>> call = postApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();
                // 어댑터에 던지기 + NotifyChange
                postAdapter.setPosts(posts);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
                rvPost.setLayoutManager(linearLayoutManager);

                rvPost.setAdapter(postAdapter);
                Log.d(TAG, "onResponse: "+posts);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d(TAG, "onFailure: 실패");
            }
        });
    }
}