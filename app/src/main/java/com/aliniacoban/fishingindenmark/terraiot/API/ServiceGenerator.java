package com.aliniacoban.fishingindenmark.terraiot.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ServiceGenerator {


    private static final String TAG = "ServiceGenerator";

    private static final String BASE_URL = "//";
    private static ServiceGenerator instance;
    private Retrofit retrofit;

    public static ServiceGenerator getInstance() {
        if (instance == null) {
            instance = new ServiceGenerator();
        }
        return instance;
    }

    private ServiceGenerator() {
        Gson gson = new GsonBuilder()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public Retrofit getRetrofitClient() {
        return retrofit;
    }
}