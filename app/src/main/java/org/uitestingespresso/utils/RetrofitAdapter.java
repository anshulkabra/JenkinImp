package org.uitestingespresso.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitAdapter {

    public static ApiInterface getApiService(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.flickr.com/") // On device
                .addConverterFactory(new GsonPConverterFactory(gson))
                .build();
         ApiInterface apiInterface=retrofit.create(ApiInterface.class);
        return apiInterface;
    }
}
