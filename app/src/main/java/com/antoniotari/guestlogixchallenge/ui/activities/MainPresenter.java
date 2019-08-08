package com.antoniotari.guestlogixchallenge.ui.activities;

import com.antoniotari.guestlogixchallenge.models.BaseModel;
import com.antoniotari.guestlogixchallenge.models.Episode;
import com.antoniotari.guestlogixchallenge.models.ShowCharacter;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void onViewCreated() {
        view.loadEpisodesFragment();
    }

    @Override
    public void onListClick(final BaseModel item) {
        if (item instanceof Episode) {
            view.loadCharactersFragment((Episode) item);
        } else if (item instanceof ShowCharacter) {
            view.loadDetailFragment((ShowCharacter) item);
        }
    }


    @Override
    public void onDestroy() {
        this.view = null;
    }
}
