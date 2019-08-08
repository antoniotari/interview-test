package com.antoniotari.guestlogixchallenge.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ShowCharacter extends BaseModel {

    @SerializedName ("status")
    private String status;
    @SerializedName ("species")
    private String species;
    @SerializedName ("type")
    private String type;
    @SerializedName ("gender")
    private String gender;
    @SerializedName ("origin")
    private Origin origin;
    @SerializedName ("location")
    private Location location;
    @SerializedName ("image")
    private String image;
    @SerializedName ("episode")
    private List<String> episode = null;


    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getType() {
        return type;
    }

    public String getGender() {
        return gender;
    }

    public Origin getOrigin() {
        return origin;
    }

    public Location getLocation() {
        return location;
    }

    public String getImage() {
        return image;
    }

    public List<String> getEpisode() {
        return episode;
    }

    public boolean isAlive() {
        return status.equals("Alive");
    }

    public void setAlive(boolean isAlive) {
        status = isAlive? "Alive":"Dead";
    }

    /**
     *
     */
    public static class Location {

        @SerializedName("name")
        private String name;
        @SerializedName("url")
        private String url;

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }

    /**
     *
     */
    public static class Origin {

        @SerializedName ("name")
        private String name;
        @SerializedName("url")
        private String url;

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }
}