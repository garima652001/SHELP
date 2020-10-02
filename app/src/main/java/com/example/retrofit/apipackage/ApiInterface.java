package com.example.retrofit.apipackage;

import com.example.retrofit.LoginResponse;
import com.example.retrofit.login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("login")
    Call<LoginResponse> loginUser (@Body login log);
}
