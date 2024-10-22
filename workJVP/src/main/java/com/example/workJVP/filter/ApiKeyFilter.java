package com.example.workJVP.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebFilter(urlPatterns = "/api-table/*")
public class ApiKeyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String apiKey = request.getHeader("API-KEY");
        System.out.println(apiKey);
        if(apiKey.equals("123123123sdfkjsdlfj")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        ((HttpServletResponse) servletResponse).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
