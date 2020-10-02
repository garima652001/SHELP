package com.example.retrofit;

public class Reotp {
    String token,email;

    public Reotp(String token, String email) {
        this.token = token;
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }
}
