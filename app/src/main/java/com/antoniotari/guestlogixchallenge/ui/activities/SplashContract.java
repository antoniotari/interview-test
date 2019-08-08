package com.antoniotari.guestlogixchallenge.ui.activities;

import com.antoniotari.guestlogixchallenge.ui.BasePresenter;
import com.antoniotari.guestlogixchallenge.ui.BaseView;

public interface SplashContract {

    interface Presenter extends BasePresenter {
        void onViewCreated();
        void getCharacters();
        void getEpisodes();
    }

    interface View extends BaseView<Presenter> {
        void finishAndGoMain();
    }
}