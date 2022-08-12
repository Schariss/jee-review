package com.adnane.jeehelloworld;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/login"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, new HttpServletResponseWrapper((HttpServletResponse) servletResponse){
            // Prevent servlet from sending Demo header
            @Override
            public void setHeader(String name, String value) {
                if(! name.equals("Demo")){
                    super.setHeader(name, value);
                }
            }
        });
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
