package com.nmp90.mycleanvideos.list;

import com.nmp90.mycleanvideos.api.InteractorSchedulers;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by nmp on 12.11.17.
 */

public class GetMoviesInteractor {

    private final MoviesRepository moviesRepository;
    private final InteractorSchedulers schedulers;

    @Inject
    public GetMoviesInteractor(MoviesRepository moviesRepository, InteractorSchedulers interactorSchedulers) {
        this.moviesRepository = moviesRepository;
        this.schedulers = interactorSchedulers;
    }

    public Single<List<Movie>> getMovies(String search) {
        return moviesRepository.getMovies(search)
                .subscribeOn(schedulers.getExecutionScheduler())
                .observeOn(schedulers.getPostExecutionScheduler());
    }
}
