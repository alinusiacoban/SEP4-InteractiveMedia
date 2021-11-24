package com.aliniacoban.fishingindenmark.terraiot.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import com.aliniacoban.fishingindenmark.terraiot.API.JsonPlaceHolderApi;
import com.aliniacoban.fishingindenmark.terraiot.API.Post;
import com.aliniacoban.fishingindenmark.terraiot.API.ServiceGenerator;
import com.google.android.gms.common.api.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Repository {
    private static Repository instance;
    private MutableLiveData<List<Post>> posts;
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

    public MutableLiveData<List<Post>> getPosts() {
        return posts;
    }

    public void updateData() {
        Retrofit retrofit = ServiceGenerator.getInstance().getRetrofitClient();
        JsonPlaceHolderApi api = retrofit.create(JsonPlaceHolderApi.class);
        final Call<List<Post>> call = api.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> responsse) {
                System.out.println(responsse.body());
                Log.d(TAG, responsse.body().toString());
                posts.postValue(responsse.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong");
                Log.e(TAG,  t.getMessage());
            }
        });
    }


}