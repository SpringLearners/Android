package com.beti.teacher.best.restandroid.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.beti.teacher.best.restandroid.R;
import com.beti.teacher.best.restandroid.business.UserService;
import com.beti.teacher.best.restandroid.business.async.UserRestProcessor;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText messageLength;
    private TextView generatedMessage;
    private TextView postGeneratedMessage;

    private UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generatedMessage = (TextView) findViewById(R.id.generatedMessage);
        messageLength = (EditText) findViewById(R.id.messageLengthField);
        postGeneratedMessage = (TextView) findViewById(R.id.postGeneratedMessage);

        userService = new UserService();
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

    private void generatePostRequest(Integer id) {
        userService.generatePostRequest(id, postGeneratedMessage);
    }

}
