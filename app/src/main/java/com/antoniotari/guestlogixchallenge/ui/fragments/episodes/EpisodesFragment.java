package com.antoniotari.guestlogixchallenge.ui.fragments.episodes;

import java.util.List;

import com.antoniotari.guestlogixchallenge.R;
import com.antoniotari.guestlogixchallenge.models.Episode;
import com.antoniotari.guestlogixchallenge.ui.fragments.BaseListFragment;
import com.antoniotari.guestlogixchallenge.ui.fragments.ListsContract.Presenter;

public class EpisodesFragment extends BaseListFragment<Episode> {

    private EpisodesAdapter episodesAdapter;

    public EpisodesFragment() {
    }

    @SuppressWarnings ("unused")
    public static EpisodesFragment newInstance() {
        return new EpisodesFragment();
    }

    @Override
    public void displayData(final List<Episode> episodes) {
        //if (episodesAdapter == null) {
            episodesAdapter = new EpisodesAdapter(episodes, mListener);
            recyclerView.setAdapter(episodesAdapter);
       // }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_item_list;
    }

    @Override
    public Presenter getPresenter() {
        if (presenter != null) {
            return presenter;
        } else {
            return new EpisodesPresenter(this);
        }
    }

    @Override
    public OnListFragmentClickListener<Episode> getListener() {
        // TODO: cast check
        return (OnListFragmentClickListener<Episode>)getActivity();
    }

}
