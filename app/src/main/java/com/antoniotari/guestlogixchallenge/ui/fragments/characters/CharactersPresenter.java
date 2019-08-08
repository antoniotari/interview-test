package com.antoniotari.guestlogixchallenge.ui.fragments.characters;

import java.util.List;

import com.antoniotari.guestlogixchallenge.data.DataSource;
import com.antoniotari.guestlogixchallenge.models.Episode;
import com.antoniotari.guestlogixchallenge.models.ShowCharacter;
import com.antoniotari.guestlogixchallenge.ui.fragments.ListsContract;

public class CharactersPresenter implements ListsContract.Presenter {

    private ListsContract.View<ShowCharacter> view;
    private int episodeId;

    public CharactersPresenter(ListsContract.View<ShowCharacter> view, int episodeId) {
        this.view = view;
        this.episodeId = episodeId;
    }

    @Override
    public void retrieveData() {
        Episode episode = DataSource.getInstance().getEpisodeWithId(episodeId);
        List<ShowCharacter> characters = DataSource.getInstance().getCharactersFromEpisode(episode);
        view.displayData(characters);
    }

    @Override
    public void onViewCreated() {

    }

    @Override
    public void onDestroy() {
        this.view = null;
    }
}
