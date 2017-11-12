package com.nmp90.mycleanvideos.di;

import android.app.Application;

import com.nmp90.mycleanvideos.api.InteractorSchedulers;
import com.nmp90.mycleanvideos.api.MoviesApi;
import com.nmp90.mycleanvideos.api.MoviesApiService;
import com.nmp90.mycleanvideos.list.ActorsApiService;
import com.nmp90.mycleanvideos.list.ActorsService;
import com.nmp90.mycleanvideos.list.MovieApiMapper;
import com.nmp90.mycleanvideos.list.MoviesApiRepository;
import com.nmp90.mycleanvideos.list.MoviesRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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

    @Provides
    @Singleton
    InteractorSchedulers provideInteractorSchedulers() {
        return new InteractorSchedulers() {
            @Override
            public Scheduler getExecutionScheduler() {
                return Schedulers.io();
            }

            @Override
            public Scheduler getPostExecutionScheduler() {
                return AndroidSchedulers.mainThread();
            }
        };
    }

    @Provides
    @Singleton
    MoviesRepository providesMoviesRepository(MoviesApiService moviesApiService, MovieApiMapper movieApiMapper) {
        return new MoviesApiRepository(moviesApiService, movieApiMapper);
    }

    @Provides
    @Singleton
    ActorsService providesActorsService() {
        return new ActorsApiService();
    }
}
