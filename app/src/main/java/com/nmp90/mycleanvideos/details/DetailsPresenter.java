package com.nmp90.mycleanvideos.details;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by nmp on 12.11.17.
 */

public class DetailsPresenter {

    private View view;
    private GetActorsInteractor getActorsInteractor;
    private CompositeDisposable compositeDisposable;

    @Inject
    public DetailsPresenter(GetActorsInteractor getActorsInteractor) {
        this.getActorsInteractor = getActorsInteractor;
        compositeDisposable = new CompositeDisposable();
    }

    public void startPresenting(View view, String movieId) {
        this.view = view;
        getMovie(movieId);
    }

    public void stopPresenting() {
        compositeDisposable.clear();
    }

    private void getMovie(String movieId) {
        Disposable disposable = getActorsInteractor.getActors(movieId)
                .subscribe(view::showActors);
        compositeDisposable.add(disposable);
    }

    interface View {
        void showActors(List<String> actors);
    }
}
