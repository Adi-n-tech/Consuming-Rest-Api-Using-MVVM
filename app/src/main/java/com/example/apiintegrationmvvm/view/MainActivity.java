package com.example.apiintegrationmvvm.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.apiintegrationmvvm.R;
import com.example.apiintegrationmvvm.databinding.ActivityMainBinding;
import com.example.apiintegrationmvvm.model.data.ModelClass;
import com.example.apiintegrationmvvm.utility.api_response_handler.APIResponse;
import com.example.apiintegrationmvvm.utility.api_response_handler.APIResponseHandler;
import com.example.apiintegrationmvvm.viewmodel.SettingViewModel;

public class MainActivity extends AppCompatActivity implements APIResponseHandler {

    private ActivityMainBinding activityMainBinding;

    private SettingViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mViewModel = new ViewModelProvider(this).get(SettingViewModel.class);
        mViewModel.init();
        mViewModel.apiResponseMutableLiveData.observe(this, apiResponse -> onAPIResponseHandler(apiResponse));


        // api call with some request code
        mViewModel.getSettings(101);

        activityMainBinding.button.setOnClickListener(view -> {
            mViewModel.getSettings(101);
        });
    }

    @Override
    public void onAPIResponseHandler(APIResponse apiResponse) {
        switch (apiResponse.requestID) {
            case 101:
                ModelClass modelClass = (ModelClass) apiResponse.data;
                Toast.makeText(this, modelClass.getData().getAppVersion(), Toast.LENGTH_SHORT).show();
        }

    }
}