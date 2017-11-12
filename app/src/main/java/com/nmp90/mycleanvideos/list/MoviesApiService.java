package com.nmp90.mycleanvideos.list;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nmp on 12.11.17.
 */

public interface MoviesApiService {
    @GET("/")
    Single<Object> getMovies(@Query("s") String searchTerm, @Query("apikey") String apiKey);
}
