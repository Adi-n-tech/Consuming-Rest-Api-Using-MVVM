package com.example.apiintegrationmvvm.network;

import com.example.apiintegrationmvvm.model.data.ApiService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This is a singleton class where we Create retrofit client and configure it to call web apis using retrofit library.
 */
public class RetrofitClient {

    //Constants
    private static final String TAG = RetrofitClient.class.getSimpleName();

    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    /**
     * Create retrofit instance.
     */
    private RetrofitClient() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Gson gson = new GsonBuilder().serializeNulls().create();

        retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public ApiService getSettingService() {
        return retrofit.create(ApiService.class);
    }
}
