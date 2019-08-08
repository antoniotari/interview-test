package com.antoniotari.guestlogixchallenge.ui.activities;

import android.content.Context;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Set;

import com.antoniotari.guestlogixchallenge.data.DataSource;
import com.antoniotari.guestlogixchallenge.models.Episode;
import com.antoniotari.guestlogixchallenge.models.ShowCharacter;
import com.antoniotari.guestlogixchallenge.network.CharactersRequest;
import com.antoniotari.guestlogixchallenge.network.EpisodesRequest;
import com.antoniotari.guestlogixchallenge.network.RickAndMortyImageLoader;

public class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View view;
    private WeakReference<Context> weakContext;

    public SplashPresenter(SplashContract.View view, Context context) {
        this.view = view;
        weakContext = new WeakReference<>(context.getApplicationContext());

        // TODO: move this in onCreate of Application class
        RickAndMortyImageLoader.getInstance().init(context.getApplicationContext());
    }

    @Override
    public void onViewCreated() {
        getEpisodes();
    }

    @Override
    public void getCharacters() {
        Context context = weakContext.get();
        if (context == null) {
            // TODO: handle errors
            return;
        }

        new CharactersRequest(context) {

            @Override
            public void onResponse(final Set<ShowCharacter> characters) {
                DataSource.getInstance().setCharacters(new ArrayList<ShowCharacter>(characters));
                view.finishAndGoMain();
            }

            @Override
            public void onError(final String error) {
                // TODO: handle errors
            }
        }.makeRequest();
    }

    @Override
    public void getEpisodes() {
        Context context = weakContext.get();
        if (context == null) {
            // TODO: handle errors
            return;
        }

        new EpisodesRequest(context) {

            @Override
            public void onResponse(final Set<Episode> episodes) {
                DataSource.getInstance().setEpisodes(new ArrayList<Episode>(episodes));
                getCharacters();
            }

            @Override
            public void onError(final String error) {
                // TODO: handle errors
            }
        }.makeRequest();
    }

    @Override
    public void onDestroy() {
        view = null;
        weakContext.clear();
    }
}
