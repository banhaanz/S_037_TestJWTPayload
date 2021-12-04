package com.demo.testjwt.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class TokenManager {
    private JWTPayload jwtPayload;

    public void setJWTPayload(JWTPayload userDetailInHttpHeader) {
        this.jwtPayload = userDetailInHttpHeader;
    }

    public JWTPayload getJWTPayload() {
        return this.jwtPayload;
    }

    @Bean
    @RequestScope
    public TokenManager getTokenManager() {
        return new TokenManager();
    }
}
