package com.nmp90.mycleanvideos.list;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by nmp on 12.11.17.
 */

public class Movie {
    private final ActorsService actorsService;
    private String title;
    private String id;

    public Movie(ActorsService actorsService, String title, String id) {
        this.title = title;
        this.id = id;
        this.actorsService = actorsService;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public Single<List<String>> getActors() {
        return actorsService.getActors(this);
    }
}
