package com.example.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;


public interface api {

    @POST("signup/otp")
    Call<OtpResponse> verifymail(@Body Verify otp_ver);
    @POST("signup/otp-resend")
    Call<ResendResponse> resend(@Body Reotp re);

    @PUT("signup")
   Call<SignupResponse> createuser(@Body signup create);


}
