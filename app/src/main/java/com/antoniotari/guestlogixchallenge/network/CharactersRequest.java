package com.antoniotari.guestlogixchallenge.network;

import android.content.Context;

import com.android.volley.Response.ErrorListener;
import com.antoniotari.guestlogixchallenge.models.ShowCharacter;
import com.antoniotari.guestlogixchallenge.network.response.CharacterResponse;

public abstract class CharactersRequest extends BaseVolleyRequest<CharacterResponse, ShowCharacter> implements ErrorListener, IRequest<CharacterResponse, ShowCharacter> {

    private static final String URL_CHARACTERS = "https://rickandmortyapi.com/api/character";

    public CharactersRequest(Context context) {
        super(context, URL_CHARACTERS, new GsonJsonParser<>(CharacterResponse.class));
    }
}