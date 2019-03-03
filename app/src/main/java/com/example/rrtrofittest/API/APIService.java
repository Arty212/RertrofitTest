package com.example.rrtrofittest.API;

import com.example.rrtrofittest.API.model.DeputyModelResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @GET("{token}/deputies{format}")
    Call<List<DeputyModelResponse>> getDeputy(
            @Path("token") String token,
            @Path("format") String format,
            @Query("current") boolean current);
}
