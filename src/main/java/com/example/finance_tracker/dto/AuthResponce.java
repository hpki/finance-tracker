package com.example.finance_tracker.dto;

public class AuthResponce {

    private String token;

    public AuthResponce(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}
