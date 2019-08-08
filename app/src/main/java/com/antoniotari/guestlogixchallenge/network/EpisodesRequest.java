package com.antoniotari.guestlogixchallenge.network;

import android.content.Context;

import com.android.volley.Response.ErrorListener;
import com.antoniotari.guestlogixchallenge.models.Episode;
import com.antoniotari.guestlogixchallenge.network.response.EpisodesResponse;

public abstract class EpisodesRequest extends BaseVolleyRequest<EpisodesResponse, Episode> implements ErrorListener, IRequest<EpisodesResponse, Episode> {

    private static final String URL_EPISODES = "https://rickandmortyapi.com/api/episode";

    public EpisodesRequest(Context context) {
        super(context, URL_EPISODES, new GsonJsonParser<>(EpisodesResponse.class));
    }
}
