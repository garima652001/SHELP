package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofit.apipackage.RetrofitClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText email, password;
    Button login;
    String emailtxt = "", passwordtxt = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        login = findViewById(R.id.button);
        email = findViewById(R.id.edittxtEmail);
        password = findViewById(R.id.edittxtPass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LoginUser();
            }
        });
    }

    private void LoginUser() {
        emailtxt = email.getText().toString();
        passwordtxt = password.getText().toString();
        if (emailtxt.isEmpty()) {
            email.setError("Email cannot be empty");
            email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailtxt).matches()) {
            email.setError("Please enter a valid email id");
            email.requestFocus();
            return;
        }
        if (passwordtxt.isEmpty()) {
            password.setError("Password cannot be empty");
            password.requestFocus();
            return;
        }
        if (passwordtxt.length() < 6) {
            password.setError("Password should atleast 6 char long");
            password.requestFocus();
            return;
        } else {
            RetroWork();
        }
    }

    private void RetroWork() {
        login log1 = new login(emailtxt, passwordtxt);
        Call<LoginResponse> call = RetrofitClient.getInstance().getApi().loginUser(log1);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(!response.isSuccessful()) {
                    try {
                        String string = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(string);
                        String wrong = jsonObject.getString("message");
                        Toast.makeText(getApplicationContext(), wrong, Toast.LENGTH_LONG).show();
                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }
                }
           else
               Toast.makeText(getApplicationContext(),response.body().getMessage()+" "+response.body().getUsername(),Toast.LENGTH_LONG).show();
               // SharedPreferences token=
            }


            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}
