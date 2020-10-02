package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class otp extends AppCompatActivity implements View.OnClickListener {
    EditText et_otp;
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        Intent intent= getIntent();
        token = intent.getStringExtra("Token");
        et_otp= findViewById(R.id.etotp);
        findViewById(R.id.btn_confirmemail).setOnClickListener(this);
        findViewById(R.id.tvresend_otp).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btn_confirmemail:
                verify();
                break;

            case R.id.tvresend_otp:
                break;
        }
    }

    private void verify() {
      String otp=et_otp.getText().toString();
        if(otp.isEmpty())
        {
            et_otp.setError("OTP is required");
            et_otp.requestFocus();
            return;
        }
        else
        {
            Verify verify= new Verify(token,otp);
            Call<OtpResponse> call= retroclient
                    .getInstance()
                    .getapi()
                    .verifymail(verify);
             call.enqueue(new Callback<OtpResponse>() {
                 @Override
                 public void onResponse(Call<OtpResponse> call, Response<OtpResponse> response) {
                     try {
                         if (response.code() == 200) {
                             OtpResponse res = response.body();
                             Toast.makeText(otp.this, res.getMessage(), Toast.LENGTH_LONG).show();
                         } else {
                             String s = response.errorBody().string();
                             JSONObject jsonObject = new JSONObject(s);
                             String message = jsonObject.getString("message");
                             Toast.makeText(otp.this, message, Toast.LENGTH_LONG).show();
                         }
                     } catch (IOException | JSONException e) {
                         e.printStackTrace();
                     }
                 }

                 @Override
                 public void onFailure(Call<OtpResponse> call, Throwable t) {
                         Toast.makeText(otp.this, t.getMessage(),Toast.LENGTH_LONG).show();

                 }
             });

        }
    }
}