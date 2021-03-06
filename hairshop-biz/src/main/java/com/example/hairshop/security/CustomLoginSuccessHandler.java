package com.example.hairshop.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
            throws IOException, ServletException {


        List<String> roleNames = new ArrayList<>();

        auth.getAuthorities().forEach(authority -> {

            roleNames.add(authority.getAuthority());

        });

        log.info("login success : {}", roleNames);

        if (roleNames.contains("ROLE_ADMIN")) {

            response.sendRedirect("/board/list");
            return;
        }

        if (roleNames.contains("ROLE_MEMBER")) {

            response.sendRedirect("/login");
            return;
        }

        response.sendRedirect("/login");
    }
}


