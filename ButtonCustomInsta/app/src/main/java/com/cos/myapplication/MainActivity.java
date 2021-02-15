package com.cos.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// 메인쓰레드 => onCreate() => UI 쓰레드(관찰) => 이벤트 쓰레드[          ] 확인 => 이벤트 리스너(OS)[ A버튼 ]
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private TextView tvTitle;

    // 매니페스트에서 설정된 자바 파일이 실행될 때 가장 먼저 실행 되는 함수
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 그림 그리는 함수 (무엇을? activity_main) => 자바
        Log.d(TAG, "onCreate");
    }


}
