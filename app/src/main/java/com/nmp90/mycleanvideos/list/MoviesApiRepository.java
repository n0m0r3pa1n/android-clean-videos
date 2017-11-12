package com.nmp90.mycleanvideos.list;

import com.nmp90.mycleanvideos.Constants;
import com.nmp90.mycleanvideos.api.MoviesApiService;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by nmp on 12.11.17.
 */

public class MoviesApiRepository implements MoviesRepository {
    private MoviesApiService apiService;
    private MovieApiMapper movieApiMapper;

    public MoviesApiRepository(MoviesApiService apiService, MovieApiMapper movieApiMapper) {
        this.apiService = apiService;
        this.movieApiMapper = movieApiMapper;
    }

    @Override
    public Single<List<Movie>> getMovies(String search) {
        return apiService.getMovies(search, Constants.API_KEY)
                .flattenAsObservable(SearchJson::getMovies)
                .map(x -> movieApiMapper.toMovie(x))
                .toList();
    }
}
