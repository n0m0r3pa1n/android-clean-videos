package com.nmp90.mycleanvideos.list;

/**
 * Created by nmp on 12.11.17.
 */

public class MovieJson {
    private String Title;
    private String Year;
    private String imdbID;
    private String Poster;

    public MovieJson(String title, String year, String imdbID, String poster) {
        Title = title;
        Year = year;
        this.imdbID = imdbID;
        Poster = poster;
    }

    public String getTitle() {
        return Title;
    }

    public String getYear() {
        return Year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getPoster() {
        return Poster;
    }
}
