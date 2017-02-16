package com.beti.teacher.best.restandroid.business;

import android.util.Log;
import android.widget.TextView;

import com.beti.teacher.best.restandroid.entity.User;
import com.beti.teacher.best.restandroid.util.RestServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserService {

    private static final String TAG = "UserService";

    public void generatePostRequest(Integer id, TextView postGeneratedMessage) {

        UserServiceInterface userServiceInterface = (UserServiceInterface) RestServiceGenerator.createHttpService(UserServiceInterface.class);
        Call<User> userCall = userServiceInterface.getUserByIdPost(id);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    postGeneratedMessage.setText(response.body().getName());
                } else {
                    Log.i(TAG, "Response was not successful");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d(TAG, "Failure getting response", t);
            }
        });

    }


}
