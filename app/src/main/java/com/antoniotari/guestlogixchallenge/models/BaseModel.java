package com.antoniotari.guestlogixchallenge.models;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

public abstract class BaseModel implements Comparable<BaseModel> {

    private int id;
    private String name;
    private String url;
    private String created;  // "2017-11-04T22:39:48.055Z"

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getCreated() {
        return created;
    }

    @VisibleForTesting
    public void setId(int id) {
        this.id = id;
    }

    // FIXME: SORTING EVERYTHING BY ID FOR NOW
    @Override
    public int compareTo(@NonNull final BaseModel o) {
        return id - o.getId();
    }
}
