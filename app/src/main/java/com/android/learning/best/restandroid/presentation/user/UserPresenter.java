package com.android.learning.best.restandroid.presentation.user;

import android.util.Log;

import com.android.learning.best.restandroid.business.UserService;
import com.android.learning.best.restandroid.entity.User;

import rx.Observable;
import rx.Subscriber;

class UserPresenter {

    private UserView userView;

    private UserService userService;

    private static final String TAG = "userPresenter";

    UserPresenter(UserView userView) {
        this.userView = userView;
        this.userService = new UserService();
    }

    void sendRequests(Integer responseLength) {
        processGetRequest(responseLength);
        processPostRequest(responseLength);
    }

    private void processGetRequest(Integer responseLength) {
        Observable<User> user = userService.getUserById(responseLength);
        user.subscribe(new Subscriber<User>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "Get request finished");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Get request failed");
            }

            @Override
            public void onNext(User user) {
                userView.setGetRequest(user.getName());
            }
        });
    }

    private void processPostRequest(Integer responseLength) {
        userService.postGetUserById(responseLength).subscribe(new Subscriber<User>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "Post request finished");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Post request failed");
            }

            @Override
            public void onNext(User user) {
                userView.setPostRequest(user.getName());
            }
        });

    }
}
