package com.antoniotari.guestlogixchallenge.models;

import java.util.List;

public class Episode extends BaseModel {

    private String air_date; // "December 2, 2013",
    private String episode;  // "S01E01",
    private List<String> characters;
    private List<ShowCharacter> characterList;

    public String getAir_date() {
        return air_date;
    }

    public String getEpisode() {
        return episode;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public List<ShowCharacter> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(final List<ShowCharacter> characterList) {
        this.characterList = characterList;
    }
}
