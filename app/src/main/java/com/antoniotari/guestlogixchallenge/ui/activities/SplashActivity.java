package com.antoniotari.guestlogixchallenge.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.antoniotari.guestlogixchallenge.R;
import com.antoniotari.guestlogixchallenge.ui.activities.SplashContract.Presenter;

public class SplashActivity extends AppCompatActivity implements SplashContract.View {

    private SplashContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        setPresenter(getPresenter());
        presenter.onViewCreated();
    }

    @Override
    public void finishAndGoMain() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void setPresenter(final Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public Presenter getPresenter() {
        if (presenter == null) {
            this.presenter = new SplashPresenter(this, getApplicationContext());
        }

        return presenter;
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }
}
