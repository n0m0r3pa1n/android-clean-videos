package com.nmp90.mycleanvideos.list;

import java.util.List;

/**
 * Created by nmp on 12.11.17.
 */

public class SearchJson {
    private List<MovieJson> Search;

    public SearchJson(List<MovieJson> Search) {
        this.Search = Search;
    }

    public List<MovieJson> getMovies() {
        return Search;
    }
}
