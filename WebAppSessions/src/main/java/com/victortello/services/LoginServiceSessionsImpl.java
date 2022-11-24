package com.victortello.services;

import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;

public class LoginServiceSessionsImpl implements LoginService{

    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
       
        return Optional.empty();
    }
    
}
