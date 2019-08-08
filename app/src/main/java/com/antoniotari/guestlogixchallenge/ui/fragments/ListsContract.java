package com.antoniotari.guestlogixchallenge.ui.fragments;

import java.util.List;

import com.antoniotari.guestlogixchallenge.models.BaseModel;
import com.antoniotari.guestlogixchallenge.ui.BasePresenter;
import com.antoniotari.guestlogixchallenge.ui.BaseView;
import com.antoniotari.guestlogixchallenge.ui.fragments.BaseListFragment.OnListFragmentClickListener;

public interface ListsContract {

    interface Presenter extends BasePresenter {
        void onViewCreated();
        void retrieveData();
    }

    interface View<T extends BaseModel> extends BaseView<Presenter> {
        void displayData(List<T> list);
        Presenter getPresenter();
        OnListFragmentClickListener<T> getListener();
    }
}