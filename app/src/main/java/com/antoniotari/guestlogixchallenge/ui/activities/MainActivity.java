package com.antoniotari.guestlogixchallenge.ui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.antoniotari.guestlogixchallenge.R;
import com.antoniotari.guestlogixchallenge.models.Episode;
import com.antoniotari.guestlogixchallenge.models.ShowCharacter;
import com.antoniotari.guestlogixchallenge.ui.activities.MainContract.Presenter;
import com.antoniotari.guestlogixchallenge.ui.activities.MainContract.View;
import com.antoniotari.guestlogixchallenge.ui.fragments.characters.CharactersFragment;
import com.antoniotari.guestlogixchallenge.ui.fragments.detail.CharacterDetail;
import com.antoniotari.guestlogixchallenge.ui.fragments.episodes.EpisodesFragment;

public class MainActivity extends AppCompatActivity implements View {

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        setPresenter(getPresenter());
        presenter.onViewCreated();
    }

    @Override
    public void onBackPressed(){
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 1) {
            Log.i("MainActivity", "popping backstack");
            fm.popBackStack();
        } else {
            Log.i("MainActivity", "nothing on backstack, calling super");
            finish();
        }
    }

    private void loadFragment(Fragment newFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.fragment_container, newFragment, null);
        transaction.commit();
    }

    @Override
    public void loadEpisodesFragment() {
        loadFragment(EpisodesFragment.newInstance());
    }

    @Override
    public void loadCharactersFragment(final Episode episode) {
        loadFragment(CharactersFragment.newInstance(episode));
    }

    @Override
    public void loadDetailFragment(final ShowCharacter character) {
        loadFragment(CharacterDetail.newInstance(character));
    }

    @Override
    public void setPresenter(final Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public Presenter getPresenter() {
        if (presenter == null) {
            this.presenter = new MainPresenter(this);
        }

        return presenter;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
