package com.example.apiintegrationmvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.apiintegrationmvvm.model.data.ModelClass;
import com.example.apiintegrationmvvm.network.APIResponseListener;
import com.example.apiintegrationmvvm.repository.MyRepository;

public class AddComplaintViewModel extends ViewModel implements APIResponseListener {

    private MyRepository helpRepository;
    public MutableLiveData<ModelClass> apiResponseMutableLiveData;


    /*  public void doAddComplaint(Integer requestID) {
          apiResponseMutableLiveData.setValue();
          helpRepository.doAddComplaint(this, requestID);
      }
  */
    @Override
    public void onSuccess(Object callResponse, Integer requestID) {
        //apiResponseMutableLiveData.setValue(APIResponse.success(callResponse, requestID));
    }

    @Override
    public void onFailure(Throwable error, Integer requestID) {
        //apiResponseMutableLiveData.setValue(APIResponse.error(error, requestID));
    }
}
