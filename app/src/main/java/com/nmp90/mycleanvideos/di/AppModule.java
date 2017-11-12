package com.nmp90.mycleanvideos.di;

import android.app.Application;

import com.nmp90.mycleanvideos.api.MoviesApi;
import com.nmp90.mycleanvideos.api.MoviesApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nmp on 12.11.17.
 */

@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    MoviesApiService provideMoviesApiService() {
        return MoviesApi.createApiService();
    }
}
