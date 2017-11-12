package com.nmp90.mycleanvideos.list;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by nmp on 12.11.17.
 */

public class MoviesPresenter {

    private final GetMoviesInteractor getMoviesInteractor;
    private final MovieUiMapper movieUiMapper;
    private View view;
    private CompositeDisposable compositeDisposable;

    @Inject
    public MoviesPresenter(GetMoviesInteractor getMoviesInteractor, MovieUiMapper movieUiMapper) {
        this.getMoviesInteractor = getMoviesInteractor;
        this.movieUiMapper = movieUiMapper;
        compositeDisposable = new CompositeDisposable();
    }

    public void startPresenting(View view) {
        this.view = view;
    }

    public void stopPresenting() {
        compositeDisposable.clear();
    }

    public void searchForMovies(String search) {
        Disposable disposable = getMoviesInteractor.getMovies(search)
                .flattenAsObservable(movies -> movies)
                .map(movieUiMapper::toUiMovie)
                .toList()
                .subscribe(view::showMovies);
        compositeDisposable.add(disposable);
    }

    interface View {
        void showMovies(List<UiMovie> movies);
    }
}
