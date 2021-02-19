package com.cos.myapplication4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;

import com.cos.myapplication4.helper.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

public class PersonActivity extends AppCompatActivity {

    private Toolbar toolbarPerson;
    private ImageView ivBack;
    private NavigationView nv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        toolbarPerson = findViewById(R.id.toolbar_person);
        setSupportActionBar(toolbarPerson);

        ivBack = findViewById(R.id.iv_back);

        ivBack.setOnClickListener(view -> {
            finish();
        });
        nv = findViewById(R.id.nv);
        NavigationViewHelper.enable(PersonActivity.this, nv);
    }
}