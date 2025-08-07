package com.example.finance_tracker.dto;

public class AuthRequest {

    public String email;
    public String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
