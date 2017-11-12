package com.nmp90.mycleanvideos.list;

/**
 * Created by nmp on 12.11.17.
 */

class UiMovie {
    private final String id;
    private String title;

    public UiMovie(String id, String title) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }
}
