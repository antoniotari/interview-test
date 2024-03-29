package com.antoniotari.guestlogixchallenge.ui.fragments.characters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import com.antoniotari.guestlogixchallenge.R;
import com.antoniotari.guestlogixchallenge.models.ShowCharacter;
import com.antoniotari.guestlogixchallenge.ui.fragments.BaseListFragment.OnListFragmentClickListener;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.ViewHolder> {

    private List<ShowCharacter> mValues;
    private final OnListFragmentClickListener<ShowCharacter> mListener;

    public CharactersAdapter(List<ShowCharacter> items, OnListFragmentClickListener<ShowCharacter> listener) {
        mValues = items;
        mListener = listener;

        Collections.sort(mValues, (final ShowCharacter o1, final ShowCharacter o2) -> {
                // put alive characters in front
                int sortIndex1 = o1.getId() + (!o1.isAlive()?1000:0);
                int sortIndex2 = o2.getId() + (!o2.isAlive()?1000:0);
                return sortIndex1 - sortIndex2;
            });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_character, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ShowCharacter showCharacter = mValues.get(position);
        holder.setData(showCharacter);
        holder.mView.setOnClickListener(v -> mListener.onClick(showCharacter));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // TODO: add image
        final View mView;
        final TextView charNameView;
        final TextView charSpeciesView;
        final TextView charStatusView;
        ShowCharacter mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            charNameView = (TextView) view.findViewById(R.id.char_name);
            charSpeciesView = (TextView) view.findViewById(R.id.char_species);
            charStatusView = (TextView) view.findViewById(R.id.char_status);
        }

        void setData(ShowCharacter showCharacter) {
            mItem = showCharacter;
            charNameView.setText(showCharacter.getName());
            charSpeciesView.setText(showCharacter.getSpecies());
            charStatusView.setText(showCharacter.getStatus());
            charStatusView.setBackgroundColor(mView.getContext().getResources().getColor(showCharacter.isAlive()?android.R.color.holo_green_light:android.R.color.holo_red_light));
        }
    }
}
