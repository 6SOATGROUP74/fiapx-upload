package com.example.demo.adapter.controller.gateway.impl;

import com.example.demo.adapter.controller.gateway.domain.JwtRequest;
import com.example.demo.adapter.controller.gateway.domain.JwtResponse;
import com.example.demo.adapter.controller.gateway.domain.UserResponse;
import com.example.demo.adapter.controller.gateway.interfaces.BucketRepositoryAdapterPort;
import com.example.demo.adapter.controller.gateway.interfaces.SecurityAdapterPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;


@Service
public class SecurityAdapter implements SecurityAdapterPort {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${rest.url.security}")
    private String URL_SECURITY;

    @Value("${admin.security.username}")
    private String username;

    @Value("${admin.security.password}")
    private String password;

    @Override
    public UserResponse consulta(final String userId) {

        String url = URL_SECURITY + "/users/" + userId;

        HttpHeaders headers = new HttpHeaders();

        headers.setBearerAuth(buildToken());

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<UserResponse> response = restTemplate.exchange(
                url, HttpMethod.GET, requestEntity, UserResponse.class
        );

        return response.getBody();

    }

    private String buildToken(){

        String url = URL_SECURITY + "/login";

        JwtRequest jwtRequest = new JwtRequest(username, password);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<JwtRequest> requestEntity = new HttpEntity<>(jwtRequest, headers);

        ResponseEntity<JwtResponse> response = restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, JwtResponse.class
        );

        return response.getBody().accessToken();


    }




}
