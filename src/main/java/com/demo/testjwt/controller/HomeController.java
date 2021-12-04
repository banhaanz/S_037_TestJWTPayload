package com.demo.testjwt.controller;

import com.demo.testjwt.config.security.JWTPayload;
import com.demo.testjwt.config.security.TokenManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class HomeController {

    @Resource(name = "getTokenManager")
    private TokenManager tokenManager;

    @GetMapping({"home","/"})
    public String getHome() throws JsonProcessingException {
        JWTPayload jwtPayload = tokenManager.getJWTPayload();
        log.info("JWT payload : {}", jwtPayload);
        return "hello home.";
    }

}
