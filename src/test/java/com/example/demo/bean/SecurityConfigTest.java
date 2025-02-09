package com.example.demo.bean;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import java.security.interfaces.RSAPublicKey;

@ExtendWith(MockitoExtension.class)
class SecurityConfigTest {

    @Mock
    private RSAPublicKey publicKey;

    @InjectMocks
    private SecurityConfig securityConfig;

    @Test
    void testBCryptPasswordEncoder() {
        BCryptPasswordEncoder encoder = securityConfig.bCryptPasswordEncoder();
        assertThat(encoder).isNotNull();
    }

    @Test
    void testJwtDecoder() {
        JwtDecoder jwtDecoder = securityConfig.jwtDecoder();
        assertThat(jwtDecoder).isInstanceOf(NimbusJwtDecoder.class);
    }
}
