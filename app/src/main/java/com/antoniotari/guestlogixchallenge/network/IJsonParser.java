package com.antoniotari.guestlogixchallenge.network;

public interface IJsonParser<T> {
    T jsonToObject(String json);
}
