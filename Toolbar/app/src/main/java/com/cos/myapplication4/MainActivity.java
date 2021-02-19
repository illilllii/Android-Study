package com.cos.myapplication4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.cos.myapplication4.helper.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";

    private Toolbar toolbarMain;
    private ImageView ivPerson, ivMenu;
    private NavigationView nv;
    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setSupportActionBar(toolbarMain);


        ivPerson.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PersonActivity.class);
            startActivity(intent);
        });


        ivMenu.setOnClickListener(view -> {
            drawer.openDrawer(GravityCompat.START);
        });

        NavigationViewHelper.enable(MainActivity.this, nv);

    }

    private void init() {
        toolbarMain = findViewById(R.id.toolbar_main);
        ivPerson = findViewById(R.id.iv_person);
        nv = findViewById(R.id.nv);
        ivMenu = findViewById(R.id.iv_menu);
        drawer = findViewById(R.id.drawer);
    }

}