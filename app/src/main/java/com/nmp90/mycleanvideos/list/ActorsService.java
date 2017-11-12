package com.nmp90.mycleanvideos.list;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by nmp on 12.11.17.
 */

public interface ActorsService {
    Single<List<String>> getActors(Movie movie);
}
