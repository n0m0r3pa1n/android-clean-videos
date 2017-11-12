package com.nmp90.mycleanvideos.di.activity;

import android.app.Activity;

import com.nmp90.mycleanvideos.MovieNavigator;
import com.nmp90.mycleanvideos.api.MoviesApiService;
import com.nmp90.mycleanvideos.list.ActorsApiService;
import com.nmp90.mycleanvideos.list.ActorsService;
import com.nmp90.mycleanvideos.list.MovieApiMapper;
import com.nmp90.mycleanvideos.list.MoviesApiRepository;
import com.nmp90.mycleanvideos.list.MoviesRepository;

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
    @PerActivity
    MovieNavigator provideMovieNavigator() {
        return new MovieNavigator(activity);
    }

    @Provides
    @PerActivity
    MoviesRepository providesMoviesRepository(MoviesApiService moviesApiService, MovieApiMapper movieApiMapper) {
        return new MoviesApiRepository(moviesApiService, movieApiMapper);
    }

    @Provides
    @PerActivity
    ActorsService providesActorsService() {
        return new ActorsApiService();
    }
}
