package com.nmp90.mycleanvideos.list;

import javax.inject.Inject;

/**
 * Created by nmp on 12.11.17.
 */

public class MovieApiMapper {
    @Inject
    public MovieApiMapper() {
    }

    public Movie toMovie(MovieJson movieJson) {
        return new Movie(movieJson.getTitle());
    }
}
