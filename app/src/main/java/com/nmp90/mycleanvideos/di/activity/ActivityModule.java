package com.nmp90.mycleanvideos.di.activity;

import android.app.Activity;

import dagger.Module;

/**
 * Created by nmp on 12.11.17.
 */

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }
}
