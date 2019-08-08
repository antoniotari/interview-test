package com.antoniotari.guestlogixchallenge.network;

import com.antoniotari.guestlogixchallenge.models.BaseModel;
import com.antoniotari.guestlogixchallenge.network.response.BaseResponse;
import com.antoniotari.guestlogixchallenge.network.response.NetworkResponseListener;

public interface IRequest<T extends BaseResponse, V extends BaseModel> extends NetworkResponseListener<V> {
    void makeRequest();
}
