package com.nmp90.mycleanvideos.list;

import android.util.Log;

import com.google.gson.Gson;
import com.nmp90.mycleanvideos.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nmp on 12.11.17.
 */

public class MoviesApi {
    public static MoviesApiService createApiService() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(message -> Log.d("OkHttp", message));
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addNetworkInterceptor(logging);
        httpClient.addInterceptor(logging);

        Gson gson = new Gson();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Constants.MOVIES_API)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build());

        return builder.build().create(MoviesApiService.class);
    }
}
