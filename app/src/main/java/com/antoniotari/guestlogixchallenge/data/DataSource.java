package com.antoniotari.guestlogixchallenge.data;

import java.util.ArrayList;
import java.util.List;

import com.antoniotari.guestlogixchallenge.models.Episode;
import com.antoniotari.guestlogixchallenge.models.ShowCharacter;

public enum DataSource {
    INSTANCE;

    public static DataSource getInstance() {
        return INSTANCE;
    }

    public List<Episode> episodes = new ArrayList<>();
    public List<ShowCharacter> characters = new ArrayList<>();

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public List<ShowCharacter> getCharacters() {
        return characters;
    }

    public void setCharacters(final List<ShowCharacter> characters) {
        this.characters = characters;
    }

    public void setEpisodes(final List<Episode> episodes) {
        this.episodes = episodes;
    }

    // TODO: map ids with episodes
    public Episode getEpisodeWithId(int id) {
        for (Episode episode: episodes) {
            if (episode.getId() == id) return episode;
        }
        return null;
    }

    // TODO: map ids with ShowCharacter
    public ShowCharacter getCharacterWithId(int id) {
        for (ShowCharacter character: characters) {
            if (character.getId() == id) return character;
        }
        return null;
    }

    public ShowCharacter getCharacterWithUrl(String url) {
        for (ShowCharacter character: characters) {
            if (character.getUrl().equals(url)) return character;
        }
        return null;
    }

    // TODO: map urls with characters
    public List<ShowCharacter> getCharactersFromEpisode(Episode episode) {
        if (episode.getCharacterList() != null) return episode.getCharacterList();

        List<ShowCharacter> charactersEpisode = new ArrayList<>();
        for (String url: episode.getCharacters()) {
            ShowCharacter character = getCharacterWithUrl(url);
            if (character != null) {
                charactersEpisode.add(character);
            }
        }

        episode.setCharacterList(charactersEpisode);

        return charactersEpisode;
    }
}
