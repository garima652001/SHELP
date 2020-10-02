package com.example.retrofit;

public class ResendResponse {
    String message,token;

    public ResendResponse(String message, String token) {
        this.message = message;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }
}
