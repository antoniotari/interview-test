package com.antoniotari.guestlogixchallenge.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Set;

import com.antoniotari.guestlogixchallenge.R;
import com.antoniotari.guestlogixchallenge.data.DataSource;
import com.antoniotari.guestlogixchallenge.models.Episode;
import com.antoniotari.guestlogixchallenge.models.ShowCharacter;
import com.antoniotari.guestlogixchallenge.network.CharactersRequest;
import com.antoniotari.guestlogixchallenge.network.EpisodesRequest;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getEpisodes();
    }

    private void getCharacters() {
        new CharactersRequest(this) {

            @Override
            public void onResponse(final Set<ShowCharacter> characters) {
                DataSource.getInstance().setCharacters(new ArrayList<ShowCharacter>(characters));
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onError(final String error) {
                // TODO: handle errors
            }
        }.makeRequest();
    }

    private void getEpisodes() {
        new EpisodesRequest(this) {

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
}
