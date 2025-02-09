package com.example.demo.adapter.controller.gateway.impl;

import com.example.demo.adapter.controller.gateway.domain.JwtRequest;
import com.example.demo.adapter.controller.gateway.domain.JwtResponse;
import com.example.demo.adapter.controller.gateway.domain.UserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.*;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SecurityAdapterTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private SecurityAdapter securityAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        ReflectionTestUtils.setField(securityAdapter, "URL_SECURITY", "http://mock-security-service");
        ReflectionTestUtils.setField(securityAdapter, "username", "admin");
        ReflectionTestUtils.setField(securityAdapter, "password", "password");

    }

/*    @Test
    void testConsulta_DeveRetornarUserResponse() {
        UserResponse mockUserResponse = new UserResponse("1", "teste", "igor");
        JwtResponse jwtResponse = new JwtResponse("accessTokenFake");

        ResponseEntity<UserResponse> mockResponseEntity = new ResponseEntity<>(mockUserResponse, HttpStatus.OK);
        ResponseEntity<JwtResponse> mockResponseJwtEntity = new ResponseEntity<>(jwtResponse, HttpStatus.OK);

        when(restTemplate.exchange(eq("http://mock-security-service/login"), eq(HttpMethod.POST), any(HttpEntity.class), eq(JwtResponse.class)))
                .thenReturn(mockResponseJwtEntity);

        when(restTemplate.exchange(anyString(), HttpMethod.GET, any(HttpEntity.class), UserResponse.class))
                .thenReturn(mockResponseEntity);

        UserResponse response = securityAdapter.consulta(anyString());

        assertNotNull(response);
    }*/

    /*@Test
    void testBuildToken_DeveRetornarAccessToken() {
        // Given
        String url = URL_SECURITY + "/login";

        JwtResponse mockJwtResponse = new JwtResponse();
        mockJwtResponse.setAccessToken("fake-jwt-token");

        ResponseEntity<JwtResponse> mockResponseEntity = new ResponseEntity<>(mockJwtResponse, HttpStatus.OK);

        // Mock do RestTemplate.exchange para simular a resposta da API de login
        when(restTemplate.exchange(eq(url), eq(HttpMethod.POST), any(HttpEntity.class), eq(JwtResponse.class)))
                .thenReturn(mockResponseEntity);

        // When
        String token = securityAdapter.buildToken();

        // Then
        assertNotNull(token);
        assertEquals("fake-jwt-token", token);

        // Verifica se a chamada ao endpoint de login foi feita corretamente
        verify(restTemplate, times(1)).exchange(eq(url), eq(HttpMethod.POST), any(HttpEntity.class), eq(JwtResponse.class));
    }*/
}
