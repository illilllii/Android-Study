package com.cos.myapplication2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private Context mContext = MainActivity.this;

    private ListView mLvMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // xml에 있는 그림이 메모리에 올라오는 과정 = 인풀레이트

        mLvMovie = findViewById(R.id.lv_movie);

        // 어댑터 => 내장 어댑터(간단한 디자인의 리스트)
        // 어댑터 직접 만들어야 되는 경우 (커스텀 리스트 만들 때)
        List<String> mid = new ArrayList<>();
        mid.add("가십걸");
        mid.add("덱스터");
        mid.add("왕자의 게임");
        mid.add("브레이킹배드");
        mid.add("배터콜사올");

        // 어댑터는 화면 사이즈와 리스트의 하나의 아이템의 사이즈를 알아야하고 그 다음에 데이터 컬렉션을 알아야 한다.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, mid);

        mLvMovie.setAdapter(adapter);
    }


}