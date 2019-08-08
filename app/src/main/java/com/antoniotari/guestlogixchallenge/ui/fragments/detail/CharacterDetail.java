package com.antoniotari.guestlogixchallenge.ui.fragments.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.antoniotari.guestlogixchallenge.R;
import com.antoniotari.guestlogixchallenge.data.DataSource;
import com.antoniotari.guestlogixchallenge.models.ShowCharacter;
import com.antoniotari.guestlogixchallenge.network.RickAndMortyImageLoader;

public class CharacterDetail extends Fragment {

    private static final String KEY_ID = "fragments.detail.id";

    @SuppressWarnings ("unused")
    public static CharacterDetail newInstance(ShowCharacter character) {
        CharacterDetail fragment = new CharacterDetail();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_ID, character.getId());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        NetworkImageView imageView = view.findViewById(R.id.image);
        TextView nameView = view.findViewById(R.id.name);
        TextView typeView = view.findViewById(R.id.type);
        TextView genderView = view.findViewById(R.id.gender);
        TextView originView = view.findViewById(R.id.origin);
        Switch switchAlive = view.findViewById(R.id.alive_switch);

        ShowCharacter character = DataSource.getInstance().getCharacterWithId(getArguments().getInt(KEY_ID));
        nameView.setText(character.getName());
        typeView.setText(character.getType());
        genderView.setText(character.getGender());
        originView.setText(character.getOrigin().getName());
        switchAlive.setChecked(character.isAlive());
        switchAlive.setOnCheckedChangeListener((final CompoundButton buttonView, final boolean isChecked) -> character.setAlive(isChecked));
        imageView.setImageUrl(character.getImage(), RickAndMortyImageLoader.getInstance().getImageLoader());

        return view;
    }
}
