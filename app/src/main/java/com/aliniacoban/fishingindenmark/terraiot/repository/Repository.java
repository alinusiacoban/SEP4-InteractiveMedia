package com.aliniacoban.fishingindenmark.terraiot.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import com.aliniacoban.fishingindenmark.terraiot.API.JsonPlaceHolderApi;
import com.aliniacoban.fishingindenmark.terraiot.Model.Terrarium;
import com.aliniacoban.fishingindenmark.terraiot.API.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Repository {
    private static Repository instance;
    private MutableLiveData<List<Terrarium>> terrarium;
    private static final String TAG = "Repository";

    private Repository() {
        terrarium = new MutableLiveData<>();
    }

    public static synchronized Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }

        return instance;
    }

    public MutableLiveData<List<Terrarium>> getTerrarium() {
        return terrarium;
    }

    public void updateData() {
        Retrofit retrofit = ServiceGenerator.getInstance().getRetrofitClient();
        JsonPlaceHolderApi api = retrofit.create(JsonPlaceHolderApi.class);
        final Call<List<Terrarium>> call = api.getTerrarium();

        call.enqueue(new Callback<List<Terrarium>>() {
            @Override
            public void onResponse(Call<List<Terrarium>> call, Response<List<Terrarium>> responsse) {
                System.out.println(responsse.body());
                Log.d(TAG, responsse.body().toString());
                terrarium.postValue(responsse.body());
            }

            @Override
            public void onFailure(Call<List<Terrarium>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");
                Log.e(TAG,  t.getMessage());
            }
        });
    }


}