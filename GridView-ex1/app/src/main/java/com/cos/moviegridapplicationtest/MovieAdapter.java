package com.cos.moviegridapplicationtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class MovieAdapter extends BaseAdapter {
    private static final String TAG = "ItemAdapter";
    private final List<Movie> movies;

    public void addItem(Movie movie) {
        movies.add(movie);
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        movies.remove(position);
        notifyDataSetChanged();
    }

    MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }


    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MainActivity mainActivityContext = (MainActivity)parent.getContext();

        LayoutInflater inflater = (LayoutInflater) mainActivityContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.movie_item, parent, false);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        ImageView imgPoster = view.findViewById(R.id.img_poster);

        tvTitle.setText(movies.get(position).getTitle());
        imgPoster.setImageResource(movies.get(position).getPic());

        return view;
    }
}
