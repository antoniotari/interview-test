package com.antoniotari.guestlogixchallenge;

import com.antoniotari.guestlogixchallenge.WeatherRepositoryImpl.Weather;

public interface WeatherRepository {
    public Weather loadWeather();
}
