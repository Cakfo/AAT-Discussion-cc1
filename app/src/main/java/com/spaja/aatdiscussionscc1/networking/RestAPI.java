package com.spaja.aatdiscussionscc1.networking;

import com.spaja.aatdiscussionscc1.model.Response;
import com.spaja.aatdiscussionscc1.model.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Spaja on 31-Oct-17.
 */

public interface RestAPI {

    String BASE_URL = "http://58489054.ngrok.io/";

    @POST ("sedam")
    @Headers ("Content-Type: application/json")
    Call<Void> sendUser(@Body User root);

    @GET ("get_me_please")
    Call<Response> getObject();

    @POST ("answer")
    Call<Void> sendObject(@Body Response response);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    RestAPI service = retrofit.create(RestAPI.class);
}
