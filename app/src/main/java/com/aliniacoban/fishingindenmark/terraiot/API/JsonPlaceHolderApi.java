package com.aliniacoban.fishingindenmark.terraiot.API;



import com.aliniacoban.fishingindenmark.terraiot.Model.Terrarium;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {



    @GET("terrariums")
    Call<List<Terrarium>> getTerrarium();


    @GET("level")
    Call<List<Level>> getLevel();
}
