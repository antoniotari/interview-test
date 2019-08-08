package com.antoniotari.guestlogixchallenge.ui.fragments.characters;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.List;

import com.antoniotari.guestlogixchallenge.R;
import com.antoniotari.guestlogixchallenge.models.Episode;
import com.antoniotari.guestlogixchallenge.models.ShowCharacter;
import com.antoniotari.guestlogixchallenge.ui.fragments.BaseListFragment;
import com.antoniotari.guestlogixchallenge.ui.fragments.ListsContract.Presenter;

public class CharactersFragment extends BaseListFragment<ShowCharacter> {

    private static final String KEY_ID = "fragments.characters.id";
    private CharactersAdapter charactersAdapter;

    public CharactersFragment() {
    }

    @SuppressWarnings ("unused")
    public static CharactersFragment newInstance(Episode episode) {
        CharactersFragment fragment = new CharactersFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_ID, episode.getId());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void displayData(final List<ShowCharacter> characters) {
        //if (charactersAdapter == null) {
            charactersAdapter = new CharactersAdapter(characters, mListener);
            recyclerView.setAdapter(charactersAdapter);
//        } else {
//            charactersAdapter.setItems(characters);
//            charactersAdapter.notifyDataSetChanged();
//        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_item_list;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public Presenter getPresenter() {
        return new CharactersPresenter(this, getArguments().getInt(KEY_ID));
    }

    @Override
    public OnListFragmentClickListener<ShowCharacter> getListener() {
        return (OnListFragmentClickListener<ShowCharacter>)getActivity();
    }
}
