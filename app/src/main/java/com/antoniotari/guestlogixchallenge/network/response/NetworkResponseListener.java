package com.antoniotari.guestlogixchallenge.network.response;

import java.util.Set;

import com.antoniotari.guestlogixchallenge.models.BaseModel;

public interface NetworkResponseListener<T extends BaseModel> {
    void onResponse(Set<T> episodes);
    void onError(String error);
}
