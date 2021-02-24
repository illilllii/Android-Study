package com.cos.movieapp2.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.cos.movieapp2.R;
import com.google.gson.annotations.SerializedName;
import com.makeramen.roundedimageview.RoundedImageView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private long id;
    private String url;
    private String title;
    private long year;
    private double rating;
    private long runtime;
    private String summary;
    @SerializedName("medium_cover_image")
    private String mediumCoverImage;

    @BindingAdapter("mediumCoverImage")
    public static void loadImage(RoundedImageView view, String mediumCoverImage) {
        Glide.with(view.getContext())
                .load(mediumCoverImage)
                .placeholder(R.drawable.main)
                .into(view);
    }
}
