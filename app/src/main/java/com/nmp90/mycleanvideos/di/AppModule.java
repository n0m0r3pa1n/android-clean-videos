package com.nmp90.mycleanvideos.di;

import android.app.Application;

import com.nmp90.mycleanvideos.api.InteractorSchedulers;
import com.nmp90.mycleanvideos.api.MoviesApi;
import com.nmp90.mycleanvideos.api.MoviesApiService;

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
}
