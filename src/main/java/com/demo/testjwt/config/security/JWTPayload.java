package com.demo.testjwt.config.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JWTPayload {
    private String merchantId;
    private String branchId;
    private String token;
}
