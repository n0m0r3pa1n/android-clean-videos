package com.nmp90.mycleanvideos.list;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

/**
 * Created by nmp on 12.11.17.
 */

public class ActorsApiService implements ActorsService {
    @Override
    public Single<List<String>> getActors(Movie movie) {
        return Single.just(new ArrayList<String>() {{
            add("Jason Statham");
            add("Vin Diesel");
            add("Silvester Stalone");
        }});
    }
}
