package com.beti.teacher.best.restandroid.business.async;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.beti.teacher.best.restandroid.business.UserServiceInterface;
import com.beti.teacher.best.restandroid.entity.User;
import com.beti.teacher.best.restandroid.util.RestServiceGenerator;

import java.io.IOException;

import retrofit2.Call;

public class UserRestProcessor extends AsyncTask<Void, Void, Void> {

    private static final String TAG = "UserRestProcessor";

    private String result;
    private Integer id;
    private TextView textView;

    public UserRestProcessor(Integer id, TextView textView) {
        this.id = id;
        this.textView = textView;
    }

    @Override
    protected Void doInBackground(Void... params) {
        Log.i(TAG, "Starting rest connection");
        UserServiceInterface userServiceInterface = (UserServiceInterface) RestServiceGenerator.createHttpService(UserServiceInterface.class);

        Call<User> callback = userServiceInterface.getUserById(id);
        try {
            Log.i(TAG, "Starting transforming received object");
            User user = callback.execute().body();
            result = user.getName();
            System.out.print("In in " + result);
        } catch (IOException e) {
            Log.d(TAG, "Callback failure", e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        textView.setText(result);
        Log.i(TAG, "Rest connection finished");
    }
}
