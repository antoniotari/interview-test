package com.antoniotari.guestlogixchallenge.ui.activities;

import com.antoniotari.guestlogixchallenge.models.BaseModel;
import com.antoniotari.guestlogixchallenge.models.Episode;
import com.antoniotari.guestlogixchallenge.models.ShowCharacter;
import com.antoniotari.guestlogixchallenge.ui.BasePresenter;
import com.antoniotari.guestlogixchallenge.ui.BaseView;
import com.antoniotari.guestlogixchallenge.ui.fragments.BaseListFragment.OnListFragmentClickListener;

public interface MainContract {

    interface Presenter extends BasePresenter {
        void onViewCreated();
        void onListClick(BaseModel episode);
    }

    interface View extends BaseView<Presenter>, OnListFragmentClickListener {
        void loadEpisodesFragment();
        void loadCharactersFragment(Episode episode);
        void loadDetailFragment(ShowCharacter character);

        default void onClick(final BaseModel item) {
            getPresenter().onListClick(item);
        }
    }
}
