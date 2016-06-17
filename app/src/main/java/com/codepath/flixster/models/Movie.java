package com.codepath.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by selinabing on 6/15/16.
 */
public class Movie {
    /*
    public String title;
    public String posterUrl;
    public int rating;
    */

    String posterPath;
    String originalTitle;
    String overview;
    boolean adult;
    String releaseDate;
    String backdropPath;
    int popularity;
    float voteAverage;


    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w780/%s",backdropPath);
    }

    public int getPopularity() {
        return popularity;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterPath = jsonObject.getString("poster_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.adult = jsonObject.getBoolean("adult");
        this.releaseDate = jsonObject.getString("release_date");
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.popularity = (int)jsonObject.getDouble("popularity");
        this.voteAverage = (float)jsonObject.getDouble("vote_average");

    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>();
        for (int x = 0; x < array.length(); x++) {
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
    /*
    public Movie(String title, String posterUrl, int rating) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.rating = rating;
    }

    public static ArrayList<Movie> getFakeMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        for(int i = 0; i<60; i++) {
            movies.add(new Movie("The Social Network", "", 75));
            movies.add(new Movie("The Internship", "", 50));
            movies.add(new Movie("The Lion King", "", 100));
        }
        return movies;
    }

    @Override
    public String toString() {
        return title + " - " + rating;
    }
    */
}
