package com.example.retrofit.api;

import com.example.retrofit.LoginResponse;
import com.example.retrofit.login;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("login")
    Call<LoginResponse> loginUser (@Body login log);
}
