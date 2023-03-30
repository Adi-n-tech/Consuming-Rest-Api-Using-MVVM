package com.example.apiintegrationmvvm.model.data;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
   /* @POST("Api name")
    Call<ModelClass> getAppSettings(
            @Body JsonObject jsonObject
    );*/

    @GET("getSettings")
    Call<ModelClass> getSettings();
}
