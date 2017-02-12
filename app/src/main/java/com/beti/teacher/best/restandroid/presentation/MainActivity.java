package com.beti.teacher.best.restandroid.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.beti.teacher.best.restandroid.R;
import com.beti.teacher.best.restandroid.business.async.UserRestProcessor;
import com.beti.teacher.best.restandroid.business.UserServiceInterface;
import com.beti.teacher.best.restandroid.entity.User;
import com.beti.teacher.best.restandroid.util.RestServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText messageLength;
    private TextView generatedMessage;
    private TextView postGeneratedMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generatedMessage = (TextView) findViewById(R.id.generatedMessage);
        messageLength = (EditText) findViewById(R.id.messageLengthField);
        postGeneratedMessage = (TextView) findViewById(R.id.postGeneratedMessage);
    }

    public void processRestRequest(View view) {
        Log.i(TAG, "Starting rest processing");
        Integer id = Integer.parseInt(String.valueOf(messageLength.getText()));
        generateGetRequest(id);
        generatePostRequest(id);
    }

    private void generateGetRequest(Integer id) {
        new UserRestProcessor(id, generatedMessage).execute();
    }

    // Dla celów testowych. Wyodrębnić do osobnego serwisu
    private void generatePostRequest(Integer id) {

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
