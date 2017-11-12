package com.nmp90.mycleanvideos.list;

import javax.inject.Inject;

/**
 * Created by nmp on 12.11.17.
 */

public class MoviesPresenter {

    @Inject
    public MoviesPresenter() {
    }

    public void searchForMovies(String search) {

    }

    interface View {
        void showMovies();
    }
}
