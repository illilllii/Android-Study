package com.cos.mvvmex1.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cos.mvvmex1.R;
import com.cos.mvvmex1.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private static final String TAG = "MovieAdapter";
    private List<Movie> movies = new ArrayList<>();

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
        Log.d(TAG, "setMovies: "+this.movies);
    }
    public long getMovieId(int i) {
        return movies.get(i).getId();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.setItem(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private TextView tvRating;
        private ImageView ivPoster;
        private RatingBar ratingBar;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvRating = itemView.findViewById(R.id.tv_rating);
            ivPoster = itemView.findViewById(R.id.iv_poster);
            ratingBar = itemView.findViewById(R.id.rating_bar);
        }

        public void setItem(Movie movie) {
            float rating = (float) movie.getRating();
            tvTitle.setText(movie.getTitle());
            tvRating.setText(movie.getRating()+"");
            ratingBar.setRating(rating/2.0f);
            Glide.with(itemView).load(movie.getMedium_cover_image()).into(ivPoster);
        }
    }
}
