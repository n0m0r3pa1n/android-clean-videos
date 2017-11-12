package com.nmp90.mycleanvideos.list;

import javax.inject.Inject;

/**
 * Created by nmp on 12.11.17.
 */

public class MovieUiMapper {

    @Inject
    public MovieUiMapper() {
    }

    public UiMovie toUiMovie(Movie movie) {
        return new UiMovie(movie.getId(), movie.getTitle());
    }
}
