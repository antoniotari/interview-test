package com.antoniotari.guestlogixchallenge.ui.fragments.episodes;

import java.util.ArrayList;

import com.antoniotari.guestlogixchallenge.data.DataSource;
import com.antoniotari.guestlogixchallenge.models.Episode;
import com.antoniotari.guestlogixchallenge.ui.fragments.ListsContract;

public class EpisodesPresenter implements ListsContract.Presenter {

    private ListsContract.View<Episode> view;

    public EpisodesPresenter(ListsContract.View<Episode> view) {
        this.view = view;
    }

    @Override
    public void retrieveData() {
        view.displayData(new ArrayList<>(DataSource.getInstance().getEpisodes()));
    }

    @Override
    public void onViewCreated() {

    }

    @Override
    public void onDestroy() {
        this.view = null;
    }
}
