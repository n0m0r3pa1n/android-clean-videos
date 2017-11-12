package com.nmp90.mycleanvideos.list;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by nmp on 12.11.17.
 */

public class Movie {
    private final ActorsService actorsService;
    private String title;


    public Movie(ActorsService actorsService, String title) {
        this.title = title;
        this.actorsService = actorsService;
    }

    public String getTitle() {
        return title;
    }

    public Single<List<String>> getActors() {
        return actorsService.getActors(this);
    }
}
