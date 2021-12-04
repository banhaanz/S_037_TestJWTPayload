package com.demo.testjwt.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Component
public class JWTGenericFilter implements Filter {

    @Resource(name = "getTokenManager")
    private TokenManager tokenManager;

    @Autowired
    private JWTHelper jwtHelper;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        log.info("URL " + (httpRequest).getServletPath());

        String token = httpRequest.getHeader(HttpHeaders.AUTHORIZATION);
        if(null != token){
            tokenManager.setJWTPayload(jwtHelper.decodeToken(token));
        }
        chain.doFilter(request, response);
    }
}
