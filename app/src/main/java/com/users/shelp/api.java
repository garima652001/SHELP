package com.users.shelp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface api {

   @PUT("signup")
   Call<SignupResponse> createuser(@Body signup create);

}
