package com.demo.testjwt.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JWTHelper {

    public static final String JWT_BEARER = "Bearer ";

    private final ObjectMapper objectMapper;
    public JWTHelper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    public String authorizationHeaderToJWTString(String authorization) {
        if(authorization != null) {
            return authorization.substring(JWT_BEARER.length());
        }
        return null;
    }
    public JWTPayload decodeToken(String token) {
        JWTPayload payload = new JWTPayload();
        DecodedJWT jwt = JWT.decode(authorizationHeaderToJWTString(token));
        String merchantId = jwt.getClaim("merchantId").asString();
        String branchId = jwt.getClaim("branchId").asString();
        payload.setMerchantId(merchantId);
        payload.setBranchId(branchId);
        payload.setToken(authorizationHeaderToJWTString(token));
        return  payload;
    }
}
