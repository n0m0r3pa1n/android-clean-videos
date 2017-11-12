package com.nmp90.mycleanvideos.di.activity;

import android.app.Activity;

import com.nmp90.mycleanvideos.api.MoviesApiService;
import com.nmp90.mycleanvideos.list.MovieApiMapper;
import com.nmp90.mycleanvideos.list.MoviesApiRepository;
import com.nmp90.mycleanvideos.list.MoviesRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nmp on 12.11.17.
 */

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @Singleton
    MoviesRepository providesMoviesRepository(MoviesApiService moviesApiService, MovieApiMapper movieApiMapper) {
        return new MoviesApiRepository(moviesApiService, movieApiMapper);
    }
}
