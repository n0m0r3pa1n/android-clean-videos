package com.nmp90.mycleanvideos.list;

import com.annimon.stream.Optional;
import com.annimon.stream.Stream;
import com.nmp90.mycleanvideos.Constants;
import com.nmp90.mycleanvideos.api.MoviesApiService;

import java.security.InvalidKeyException;
import java.util.List;

import io.reactivex.Single;

/**
 * Created by nmp on 12.11.17.
 */

public class MoviesApiRepository implements MoviesRepository {
    private MoviesApiService apiService;
    private MovieApiMapper movieApiMapper;
    private SearchJson searchJson;

    public MoviesApiRepository(MoviesApiService apiService, MovieApiMapper movieApiMapper) {
        this.apiService = apiService;
        this.movieApiMapper = movieApiMapper;
    }

    @Override
    public Single<List<Movie>> getMovies(String search) {
        return apiService.getMovies(search, Constants.API_KEY)
                .doOnSuccess(this::cacheJson)
                .flattenAsObservable(SearchJson::getMovies)
                .map(x -> movieApiMapper.toMovie(x))
                .toList();
    }

    private SearchJson cacheJson(SearchJson searchJson) {
        return this.searchJson = searchJson;
    }

    @Override
    public Single<Movie> getMovie(String id) {
        Optional<MovieJson> movieOptional = Stream.of(searchJson.getMovies())
                .filter(x -> x.getImdbID().equals(id))
                .findFirst();
        if (movieOptional.isPresent()) {
            Movie movie = movieApiMapper.toMovie(movieOptional.get());
            return Single.just(movie);
        } else {
            return Single.error(new InvalidKeyException());
        }
    }

}
