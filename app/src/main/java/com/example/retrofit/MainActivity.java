package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView name,token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkuser();
        SharedPreferences preferences=getApplicationContext().getSharedPreferences("Name",0);
        name= findViewById(R.id.tv_namesharedpref);
        name.setText(preferences.getString("Name",null));
        SharedPreferences preference=getApplicationContext().getSharedPreferences("Token",0);
         token= findViewById(R.id.tv_tokenfinal);
        token.setText(preference.getString("Token",null));
    }
  public void checkuser()
  {
      Boolean check= Boolean.valueOf(Sharedprefs.readShared(MainActivity.this,"Clip","true"));

      Intent intro = new Intent(MainActivity.this, SignupActivity.class);
      intro.putExtra("Clip",check);

      if(check){
          startActivity(intro);
      }
  }
}