package com.nmp90.mycleanvideos;

import android.app.Activity;

import com.nmp90.mycleanvideos.details.DetailsActivity;

/**
 * Created by nmp on 12.11.17.
 */

public class MovieNavigator {
    private final Activity activity;

    public MovieNavigator(Activity activity) {
        this.activity = activity;
    }

    public void openMovieDetails(String id) {
        DetailsActivity.open(id, activity);
    }
}
