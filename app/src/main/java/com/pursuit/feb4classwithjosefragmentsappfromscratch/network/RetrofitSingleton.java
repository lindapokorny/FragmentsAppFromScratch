package com.pursuit.feb4classwithjosefragmentsappfromscratch.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static Retrofit instance; //instance of my retrofit

    private RetrofitSingleton(){} //constructor

    public static Retrofit getInstance(){
        if (instance!= null){
            return instance;
        }
        instance = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();
return instance;
    }
}
