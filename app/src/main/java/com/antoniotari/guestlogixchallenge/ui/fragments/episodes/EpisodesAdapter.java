package com.antoniotari.guestlogixchallenge.ui.fragments.episodes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.antoniotari.guestlogixchallenge.R;
import com.antoniotari.guestlogixchallenge.models.Episode;
import com.antoniotari.guestlogixchallenge.ui.fragments.BaseListFragment.OnListFragmentClickListener;

public class EpisodesAdapter extends RecyclerView.Adapter<EpisodesAdapter.ViewHolder> {

    private final List<Episode> mValues;
    private final OnListFragmentClickListener<Episode> mListener;

    public EpisodesAdapter(List<Episode> items, OnListFragmentClickListener<Episode> listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Episode episode = mValues.get(position);
        holder.setData(episode);
        holder.mView.setOnClickListener(v -> mListener.onClick(holder.mItem));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView episodeNameView;
        public final TextView episodeCodeView;
        public final TextView episodeDateView;
        public Episode mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            episodeNameView = (TextView) view.findViewById(R.id.episode_name);
            episodeCodeView = (TextView) view.findViewById(R.id.episode_code);
            episodeDateView = (TextView) view.findViewById(R.id.episode_date);
        }

        void setData(Episode episode) {
            mItem = episode;
            episodeNameView.setText(episode.getName());
            episodeCodeView.setText(episode.getEpisode());
            episodeDateView.setText(episode.getAir_date());
        }
    }
}
