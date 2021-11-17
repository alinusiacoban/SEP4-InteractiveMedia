package com.aliniacoban.fishingindenmark.terraiot.API;

import com.aliniacoban.fishingindenmark.terraiot.API.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();
}
