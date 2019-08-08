package com.antoniotari.guestlogixchallenge.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import java.io.File;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;

public enum RickAndMortyImageLoader {
    INSTANCE;

    private RequestQueue mRequestQueue;
    private File cacheDir;

    public void init(Context context) {
        cacheDir = context.getCacheDir();
        mRequestQueue = getRequestQueue();
    }

    public static RickAndMortyImageLoader getInstance() {
        return INSTANCE;
    }

    private RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            Cache cache = new DiskBasedCache(cacheDir, 10 * 1024 * 1024);
            Network network = new BasicNetwork(new HurlStack());
            mRequestQueue = new RequestQueue(cache, network);
            mRequestQueue.start();
        }
        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        if (INSTANCE.cacheDir == null || INSTANCE.mRequestQueue == null) {
            throw new RuntimeException("please call init before using this method");
        }

        ImageLoader mImageLoader = new ImageLoader(getRequestQueue(), new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> cache = new LruCache<String, Bitmap>(20);
            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }
            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
            }
        });
        return mImageLoader;
    }
}
