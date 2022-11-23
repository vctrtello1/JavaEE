package com.victortello.services;

import java.util.Arrays;
import java.util.Optional;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class LoginServiceImpl implements LoginService {

    @Override
    public Optional<String> getUsername(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies() != null ? request.getCookies() : new Cookie[0];
        return Arrays.stream(cookies).filter(c -> "username".equals(c.getName()))
                .map(Cookie::getValue).findAny();

    }

}
