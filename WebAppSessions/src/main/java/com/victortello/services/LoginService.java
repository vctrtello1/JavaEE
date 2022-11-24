package com.victortello.services;

import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;

public interface LoginService {

    Optional<String> getUsername(HttpServletRequest request);

}
