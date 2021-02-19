package com.cos.myapplication6;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SearchFragment extends Fragment {

    private static final String TAG = "SearchFragment";
    private TextView tvTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Context context = container.getContext();
        MainActivity at = (MainActivity)context;
        at.num = 1;
        Log.d(TAG, "onCreateView: at num"+ at.num);
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        tvTitle = view.findViewById(R.id.tv_title);
        tvTitle.setText("FragmentSearch");
        return view;
    }
}

