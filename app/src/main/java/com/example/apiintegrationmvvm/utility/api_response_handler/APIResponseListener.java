package com.example.apiintegrationmvvm.utility.api_response_handler;


public interface APIResponseListener {

    public void onSuccess(Object callResponse, Integer requestID);

    public void onFailure(Throwable error, Integer requestID);
}