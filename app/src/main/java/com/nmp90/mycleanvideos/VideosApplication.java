package com.nmp90.mycleanvideos;

import android.app.Application;

import com.nmp90.mycleanvideos.di.AppModule;
import com.nmp90.mycleanvideos.di.ApplicationComponent;
import com.nmp90.mycleanvideos.di.DaggerApplicationComponent;

/**
 * Created by nmp on 12.11.17.
 */

public class VideosApplication extends Application {
    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().appModule(new AppModule(this)).build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
