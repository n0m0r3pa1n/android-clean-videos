package com.nmp90.mycleanvideos.details;

import com.nmp90.mycleanvideos.api.InteractorSchedulers;
import com.nmp90.mycleanvideos.list.Movie;
import com.nmp90.mycleanvideos.list.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by nmp on 12.11.17.
 */

public class GetActorsInteractor {
    private final MoviesRepository moviesRepository;
    private final InteractorSchedulers schedulers;

    @Inject
    public GetActorsInteractor(MoviesRepository moviesRepository, InteractorSchedulers interactorSchedulers) {
        this.moviesRepository = moviesRepository;
        this.schedulers = interactorSchedulers;
    }

    public Single<List<String>> getActors(String movieId) {
        return moviesRepository.getMovie(movieId)
                .flatMap(Movie::getActors)
                .subscribeOn(schedulers.getExecutionScheduler())
                .observeOn(schedulers.getPostExecutionScheduler());
    }
}
