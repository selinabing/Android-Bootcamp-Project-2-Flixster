package com.codepath.flixster;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class DetailedActivity extends AppCompatActivity {

    TextView tvDetailedTitle;
    TextView tvDetailedOverview;
    ImageView ivDetailedImage;
    CheckBox cbDetailedAdult;
    TextView tvDetailedReleaseDate;
    ProgressBar pbPopularity;
    RatingBar rbDetailedRating;

    String title;
    String overview;
    String posterPath;
    boolean adult;
    String releaseDate;
    int popularity;
    float rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        title = getIntent().getStringExtra("title");
        overview = getIntent().getStringExtra("overview");
        adult = getIntent().getBooleanExtra("adult",true);
        posterPath = getIntent().getStringExtra("posterPath");
        releaseDate = getIntent().getStringExtra("releaseDate");
        popularity = getIntent().getIntExtra("popularity",0);
        rating = getIntent().getFloatExtra("voteAverage",(float)0.0);

        ivDetailedImage = (ImageView) findViewById(R.id.ivDetailedMovieImage);
        ivDetailedImage.setImageResource(0);
        tvDetailedTitle = (TextView) findViewById(R.id.tvDetailedTitle);
        tvDetailedOverview = (TextView) findViewById(R.id.tvDetailedOverview);
        cbDetailedAdult = (CheckBox) findViewById(R.id.cbDetailedAdult);
        tvDetailedReleaseDate = (TextView) findViewById(R.id.tvDetailedReleaseDate);
        pbPopularity = (ProgressBar) findViewById(R.id.pbPopularity);
        rbDetailedRating = (RatingBar) findViewById(R.id.rbDetailedRating);

        tvDetailedTitle.setText(title);
        tvDetailedOverview.setText(overview);
        cbDetailedAdult.setChecked(adult);
        tvDetailedReleaseDate.setText(releaseDate);
        pbPopularity.setProgress(popularity*2);
        Log.d("Debug",Float.toString(rating));
        rbDetailedRating.setRating(rating);
        Picasso.with(this).load(posterPath).transform(new RoundedCornersTransformation(20,20)).fit().centerCrop().placeholder(R.drawable.loading_vertical).into(ivDetailedImage);

    }

    public void onSubmit(View view){
        this.finish();
    }

}
