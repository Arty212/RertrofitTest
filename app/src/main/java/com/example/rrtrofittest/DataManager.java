package com.example.rrtrofittest;

import com.example.rrtrofittest.API.APIConfig;
import com.example.rrtrofittest.API.APIService;
import com.example.rrtrofittest.API.ServiceConstructor;
import com.example.rrtrofittest.API.model.DeputyModelResponse;

import java.util.List;

import retrofit2.Call;

public class DataManager {

    private APIService mAPIService;

    private static DataManager instance;

    private DataManager() {
        mAPIService = ServiceConstructor.CreateService(APIService.class);
    }

    public static DataManager getInstance() {
        if (instance == null)
            instance = new DataManager();
        return instance;
    }

    public Call<List<DeputyModelResponse>> getDeputy(boolean current) {
        return mAPIService.getDeputy(APIConfig.API_KEY, APIConfig.FORMAT, current);
    }
}
