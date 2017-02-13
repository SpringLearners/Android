package com.beti.teacher.best.restandroid.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RestServiceGenerator {

    //TODO: skoro wszystkie pola i metody statyczne to może prywatny konstruktor? chyba nie ma sensu tworzyć instancji tej klasy

    //TODO: to powinno być prywatne pole
    public static final String BASE_URL = "http://10.0.2.2:8080";

    public static Object createHttpService(Class interfaceClass) {
        //TODO: ten obiekt jest nieużywany, nie przekazałeś go jak argument metody create poniżej
        Gson gson = new GsonBuilder().setLenient().create();

        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(interfaceClass);
    }
}
