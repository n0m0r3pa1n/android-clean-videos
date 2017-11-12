package com.nmp90.mycleanvideos.list;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by nmp on 12.11.17.
 */

public interface MoviesRepository {
    Single<List<Movie>> getMovies(String search);

    Single<Movie> getMovie(String id);
}
