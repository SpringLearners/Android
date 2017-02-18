package com.android.learning.best.restandroid.business.service;

import com.android.learning.best.restandroid.entity.User;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface UserServiceInterface {

    @GET("/user/{id}")
    Observable<User> getUserById(@Path("id") Integer userId);

    @POST("/user/post/")
    Observable<User> getUserByIdPost(@Body Integer id);

}
