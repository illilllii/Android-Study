package com.cos.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SubActivity extends AppCompatActivity {

    private static final String TAG = "SubActivity";
    private FloatingActionButton mfabTop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent mainIntent = getIntent();
        User user = (User)mainIntent.getSerializableExtra("user");
        Log.d(TAG, "user: "+ user);

//        Bundle bundle = intent.getBundleExtra("userBundle");
//        Log.d(TAG, "userBundle: "+bundle.getSerializable("user"));

        mfabTop = findViewById(R.id.fab_top);
        mfabTop.setOnClickListener(view -> {
            // 인증이 성공함
            Intent newIntent = new Intent();
            newIntent.putExtra("auth","ok");
            setResult(1, newIntent);
            finish(); //pop
        });
    }
}