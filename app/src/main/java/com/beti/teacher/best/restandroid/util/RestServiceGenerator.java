package com.beti.teacher.best.restandroid.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RestServiceGenerator {

    private RestServiceGenerator() {

    }

    private static final String BASE_URL = "http://10.0.2.2:8080";

    public static Object createHttpService(Class interfaceClass) {
        Gson gson = new GsonBuilder().setLenient().create();

        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build().create(interfaceClass);
    }
}
