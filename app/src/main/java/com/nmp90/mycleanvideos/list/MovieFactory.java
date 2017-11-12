package com.nmp90.mycleanvideos.list;

import javax.inject.Inject;

/**
 * Created by nmp on 12.11.17.
 */

public class MovieFactory {

    private ActorsService actorsService;

    @Inject
    public MovieFactory(ActorsService actorsService) {
        this.actorsService = actorsService;
    }

    public Movie toMovie(String title, String id) {
        return new Movie(actorsService, title, id);
    }
}
