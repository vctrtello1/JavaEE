package com.victortello.services;

import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginServiceSessionsImpl implements LoginService{

    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if(username != null){
            return Optional.of(username);
        }
       
        return Optional.empty();
    }
    
}
