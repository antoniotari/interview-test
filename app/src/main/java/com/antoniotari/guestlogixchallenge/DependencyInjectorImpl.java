package com.antoniotari.guestlogixchallenge;

public class DependencyInjectorImpl implements DependencyInjector {

    @Override
    public WeatherRepositoryImpl weatherRepository() {
        return new WeatherRepositoryImpl();
    }

}
