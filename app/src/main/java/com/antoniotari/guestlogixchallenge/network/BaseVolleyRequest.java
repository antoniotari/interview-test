package com.antoniotari.guestlogixchallenge.network;

import android.content.Context;

import java.io.UnsupportedEncodingException;
import java.util.Set;
import java.util.TreeSet;

import com.google.gson.JsonSyntaxException;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.Volley;
import com.antoniotari.guestlogixchallenge.models.BaseModel;
import com.antoniotari.guestlogixchallenge.network.response.BaseResponse;
import com.antoniotari.guestlogixchallenge.network.response.Info;


public abstract class BaseVolleyRequest<T extends BaseResponse, V extends BaseModel> implements ErrorListener, IRequest<T, V> {

    private RequestQueue queue;
    private final Set<V> episodes = new TreeSet<V>();
    private IJsonParser<T> jsonParser;
    private final String baseUrl;

    /*package visible*/ BaseVolleyRequest(Context context, String url, IJsonParser<T> jsonParser) {
        queue = Volley.newRequestQueue(context);
        this.jsonParser = jsonParser;
        this.baseUrl = url;
    }

    private void makeRequest(String url) {
        Request<T> request = new Request<T>(Method.GET, url, this) {

            @Override
            protected void deliverResponse(T response) {
                episodes.addAll(response.getResults());

                final Info info = response.getInfo();
                if (!info.getNext().isEmpty()) {
                    makeRequest(info.getNext());
                } else {
                    onResponse(episodes);
                }
            }

            @Override
            protected Response<T> parseNetworkResponse(NetworkResponse response) {
                try {
                    String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
                    return Response.success(jsonParser.jsonToObject(json), HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                } catch (JsonSyntaxException e) {
                    return Response.error(new ParseError(e));
                }
            }
        };
        queue.add(request);
    }



    @Override
    public void onErrorResponse(final VolleyError error) {
        // TODO: handle errors
        onError(error.getLocalizedMessage());
    }


    @Override
    public void makeRequest() {
        makeRequest(baseUrl);
    }
}
