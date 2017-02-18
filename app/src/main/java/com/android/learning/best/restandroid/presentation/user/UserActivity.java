package com.android.learning.best.restandroid.presentation.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.learning.best.restandroid.R;

public class UserActivity extends AppCompatActivity implements UserView {

    private static final String TAG = "UserActivity";

    private EditText messageLength;
    private TextView generatedMessage;
    private TextView postGeneratedMessage;

    private UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        generatedMessage = (TextView) findViewById(R.id.generatedMessage);
        messageLength = (EditText) findViewById(R.id.messageLengthField);
        postGeneratedMessage = (TextView) findViewById(R.id.postGeneratedMessage);

        userPresenter = new UserPresenter(this);

    }

    public void processRestRequest(View view) {
        Log.i(TAG, "Starting rest processing");
        Integer id = Integer.parseInt(String.valueOf(messageLength.getText()));
        userPresenter.sendRequests(id);
    }

    @Override
    public void setGetRequest(String getData) {
        this.generatedMessage.setText(getData);
    }

    @Override
    public void setPostRequest(String postData) {
        this.postGeneratedMessage.setText(postData);
    }
}
