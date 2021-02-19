package com.cos.myapplication4.helper;

import android.content.Context;
import android.content.Intent;

import com.cos.myapplication4.MainActivity;
import com.cos.myapplication4.PersonActivity;
import com.cos.myapplication4.R;
import com.google.android.material.navigation.NavigationView;

public class NavigationViewHelper {
    private static final String TAG = "NavigationViewHelper";
    public static void enable(Context context, NavigationView view) {
        view.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if(id == R.id.item1) {
                Intent intent = new Intent(context, PersonActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                context.startActivity(intent);
            } else  if(id==R.id.item2) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                context.startActivity(intent);
            } else if(id==R.id.item3) {

            }

            return false;
        });
    }
}
