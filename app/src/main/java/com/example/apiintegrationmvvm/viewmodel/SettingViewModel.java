package com.example.apiintegrationmvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.apiintegrationmvvm.utility.api_response_handler.APIResponse;
import com.example.apiintegrationmvvm.utility.api_response_handler.APIResponseListener;
import com.example.apiintegrationmvvm.repository.MyRepository;

public class SettingViewModel extends ViewModel implements APIResponseListener {

    private MyRepository myRepository;
    public MutableLiveData<APIResponse> apiResponseMutableLiveData;

    public void init() {
        apiResponseMutableLiveData = new MutableLiveData<>();
        myRepository = new MyRepository();
    }


    public void getSettings(Integer requestID) {
        myRepository.getSettings(this, requestID);
    }


    @Override
    public void onSuccess(Object callResponse, Integer requestID) {
        apiResponseMutableLiveData.setValue(APIResponse.success(callResponse, requestID));
    }

    @Override
    public void onFailure(Throwable error, Integer requestID) {
        apiResponseMutableLiveData.setValue(APIResponse.failure(error, requestID));
    }
}
