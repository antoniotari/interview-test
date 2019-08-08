package com.antoniotari.guestlogixchallenge.network;

import com.google.gson.Gson;

import com.antoniotari.guestlogixchallenge.network.response.BaseResponse;

public class GsonJsonParser<T extends BaseResponse> implements IJsonParser<T> {

    private Class<T> clazz;

    public GsonJsonParser(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T jsonToObject(final String json) {
        return new Gson().fromJson(json, clazz);
    }
}
