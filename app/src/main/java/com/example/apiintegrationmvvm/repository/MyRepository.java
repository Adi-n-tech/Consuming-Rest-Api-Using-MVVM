package com.example.apiintegrationmvvm.repository;

import com.example.apiintegrationmvvm.model.data.ApiService;
import com.example.apiintegrationmvvm.model.data.ModelClass;
import com.example.apiintegrationmvvm.utility.api_response_handler.APIResponseListener;
import com.example.apiintegrationmvvm.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyRepository {
    public void getSettings(APIResponseListener apiResponseListener, Integer requestID) {
        ApiService retroInterface = RetrofitClient.getInstance().getSettingService();
        Call<ModelClass> unitsResponseCall = retroInterface.getSettings();
        unitsResponseCall.enqueue(new Callback<ModelClass>() {
            @Override
            public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                if (response.isSuccessful()) {
                    ModelClass result = response.body();
                    apiResponseListener.onSuccess(result, requestID);
                } else {
                    apiResponseListener.onSuccess("Something went wrong", requestID);
                }
            }

            @Override
            public void onFailure(Call<ModelClass> call, Throwable t) {
                apiResponseListener.onFailure(t, requestID);
            }
        });
    }
}
