package com.nmp90.mycleanvideos.list;

import javax.inject.Inject;

/**
 * Created by nmp on 12.11.17.
 */

public class MovieApiMapper {

    private MovieFactory movieFactory;

    @Inject
    public MovieApiMapper(MovieFactory movieFactory) {
        this.movieFactory = movieFactory;
    }

    public Movie toMovie(MovieJson movieJson) {
        return movieFactory.toMovie(movieJson.getTitle());
    }
}
