package com.beti.teacher.best.restandroid.business;

import com.beti.teacher.best.restandroid.entity.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserServiceInterface {

    @GET("/user/{id}")
    Call<User> getUserById(@Path("id") Integer userId);

    @POST("/user/post/")
    Call<User> getUserByIdPost(@Body Integer id);

}
