package com.example.retrofittest;

import com.example.retrofittest.API.APIConfig;
import com.example.retrofittest.API.APIService;
import com.example.retrofittest.API.ServiceConstructor;
import com.example.retrofittest.API.model.DeputyModelResponse;

import java.util.List;

import retrofit2.Call;

public class DataManager {

    private static DataManager instance;

    private APIService mAPIService;

    private DataManager() {
        mAPIService = ServiceConstructor.CreateService(APIService.class);
    }

    public static DataManager getInstance() {
        if (instance == null)
            instance = new DataManager();
        return instance;
    }

    public Call<List<DeputyModelResponse>> getDeputy(boolean current) {
        return mAPIService.getDeputy(
                APIConfig.TOKEN,
                APIConfig.FORMAT,
                current);
    }
}
