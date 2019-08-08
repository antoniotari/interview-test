package com.antoniotari.guestlogixchallenge.ui;

import android.support.annotation.LayoutRes;

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
    T getPresenter();
    @LayoutRes int getLayoutId();
}
