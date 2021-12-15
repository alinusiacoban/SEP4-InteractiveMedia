package com.aliniacoban.fishingindenmark.terraiot.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("level")
    Call<List<Level>> getLevel();
}
