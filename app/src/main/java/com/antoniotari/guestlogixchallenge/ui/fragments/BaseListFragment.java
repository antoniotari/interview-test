package com.antoniotari.guestlogixchallenge.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antoniotari.guestlogixchallenge.models.BaseModel;
import com.antoniotari.guestlogixchallenge.ui.fragments.ListsContract.Presenter;
import com.antoniotari.guestlogixchallenge.ui.fragments.episodes.EpisodesFragment;

public abstract class BaseListFragment<T extends BaseModel> extends Fragment implements ListsContract.View<T> {

    protected RecyclerView recyclerView;

    protected EpisodesFragment.OnListFragmentClickListener mListener;
    protected ListsContract.Presenter presenter;


    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);

        setPresenter(getPresenter());
        presenter.onViewCreated();

        if (view instanceof RecyclerView) {
            recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        }
        presenter.retrieveData();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof EpisodesFragment.OnListFragmentClickListener) {
            mListener = getListener();
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void setPresenter(final Presenter presenter) {
        this.presenter = presenter;
    }


    public interface OnListFragmentClickListener<T extends BaseModel> {
        void onClick(T item);
    }
}