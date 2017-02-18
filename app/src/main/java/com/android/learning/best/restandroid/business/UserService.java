package com.android.learning.best.restandroid.business;

import com.android.learning.best.restandroid.business.service.UserServiceInterface;
import com.android.learning.best.restandroid.entity.User;
import com.android.learning.best.restandroid.util.RestServiceGenerator;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UserService {

    private UserServiceInterface userServiceInterface;

    public UserService() {
        userServiceInterface = (UserServiceInterface) RestServiceGenerator.createHttpService(UserServiceInterface.class);
    }

    public Observable<User> getUserById(Integer id) {
        return userServiceInterface.getUserById(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<User> postGetUserById(Integer id) {
        return userServiceInterface.getUserByIdPost(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }


}
