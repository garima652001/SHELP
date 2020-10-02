package com.example.retrofit;

public class LoginResponse {
    String userId,message,username,token;

    public String getToken() {
        return token;
    }

    public LoginResponse(String userId, String message, String username, String token) {
        this.userId = userId;
        this.message = message;
        this.username = username;
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
