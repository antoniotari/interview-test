package com.antoniotari.guestlogixchallenge.network.response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import com.antoniotari.guestlogixchallenge.models.BaseModel;

public abstract class BaseResponse<T extends BaseModel> {

    @SerializedName ("info")
    private Info info;

    public Info getInfo() {
        return info;
    }

    @SerializedName("results")
    private List<T> results;

    public List<T> getResults() {
        return results;
    }
}
