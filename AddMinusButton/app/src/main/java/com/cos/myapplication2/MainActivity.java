package com.cos.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private Button mbtnAdd, mbtnMinus;
    private TextView mtvNum;
    private Integer num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // xml에 있는 그림이 메모리에 올라오는 과정 = 인풀레이트

        init();
        initSetting();
        initListener();
    }

    private void init() {
        mbtnAdd = findViewById(R.id.btn_add);
        mbtnMinus = findViewById(R.id.btn_minus);
        mtvNum = findViewById(R.id.tv_num);
    }

    private void initSetting() {
        num = 1;
        mtvNum.setText(num.toString());
    }
    private void initListener() {
        mbtnAdd.setOnClickListener(view -> {
            Log.d(TAG,"initListener: ");
            num++;
            mtvNum.setText(num.toString());
        });
        mbtnMinus.setOnClickListener(view -> {
            num--;
            mtvNum.setText(num.toString());
        });
    }
}