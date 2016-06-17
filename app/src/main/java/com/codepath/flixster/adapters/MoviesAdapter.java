package com.codepath.flixster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.flixster.R;
import com.codepath.flixster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by selinabing on 6/15/16.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    private static class ViewHolder {
        TextView tvTitle;
        TextView tvOverview;
        ImageView ivImage;
    }
    public MoviesAdapter(Context context, List<Movie> movies) {
        super(context,android.R.layout.simple_list_item_1,movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
            viewHolder.ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // find the image view
        // clear out image from convertView
        viewHolder.ivImage.setImageResource(0);

        //populate data
        viewHolder.tvTitle.setText(movie.getOriginalTitle());
        viewHolder.tvOverview.setText(movie.getOverview());

        if(getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Picasso.with(getContext()).load(movie.getBackdropPath()).transform(new RoundedCornersTransformation(20, 20)).placeholder(R.drawable.loading_horizontal).into(viewHolder.ivImage);
        } else {
            Picasso.with(getContext()).load(movie.getPosterPath()).transform(new RoundedCornersTransformation(20, 20)).placeholder(R.drawable.loading_vertical).into(viewHolder.ivImage);
        }
        return convertView;
    }

    /*
    public MoviesAdapter(Context context, ArrayList<Movie> movies) {
        super(context, R.layout.item_movie, movies);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Movie movie = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
        }

        // Lookup view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        ImageView ivPoster = (ImageView) convertView.findViewById(R.id.ivPoster);

        // Populate the data into the template view using the data object
        tvTitle.setText(movie.title);
        //tvHome.setText(user.hometown);

        Log.d("MoviesAdapter", "Position: " + position);
        //NOTE: when printing out positions, it wouldn't print out all (180) movies
        //it only prints whatever is visible on screen, plus some ±1..2..3.. items


        String imageUri = "https://i.imgur.com/tGbaZCY.jpg";
        Picasso.with(getContext()).load(imageUri).into(ivPoster);

        // Return the completed view to render on screen
        return convertView;
    }
    */
}
