package com.example.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface api {

    @POST("signup/otp")
    Call<OtpResponse> verifymail(@Body Verify otp_ver);

    @PUT("signup")
   Call<SignupResponse> createuser(@Body signup create);


}
