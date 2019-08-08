package com.antoniotari.guestlogixchallenge;

public class WeatherRepositoryImpl implements WeatherRepository{

    public Weather loadWeather() {
        return new Weather();
    }

    public static class Weather {
        public boolean rain;
    }

    public enum WeatherState {
        RAIN,
        SUN
    }
}
