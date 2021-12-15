package com.aliniacoban.fishingindenmark.terraiot.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import com.aliniacoban.fishingindenmark.terraiot.API.JsonPlaceHolderApi;
import com.aliniacoban.fishingindenmark.terraiot.API.Level;
import com.aliniacoban.fishingindenmark.terraiot.API.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Repository {
    private static Repository instance;
    private MutableLiveData<List<Level>> posts;
    private static final String TAG = "Repository";

    private Repository() {
        posts = new MutableLiveData<>();
    }

    public static synchronized Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }

        return instance;
    }

    public MutableLiveData<List<Level>> getPosts() {
        return posts;
    }

    public void updateData() {
        Retrofit retrofit = ServiceGenerator.getInstance().getRetrofitClient();
        JsonPlaceHolderApi api = retrofit.create(JsonPlaceHolderApi.class);
        final Call<List<Level>> call = api.getLevel();

        call.enqueue(new Callback<List<Level>>() {
            @Override
            public void onResponse(Call<List<Level>> call, Response<List<Level>> responsse) {
                System.out.println(responsse.body());
                Log.d(TAG, responsse.body().toString());
                posts.postValue(responsse.body());
            }

            @Override
            public void onFailure(Call<List<Level>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");
                Log.e(TAG,  t.getMessage());
            }
        });
    }


}