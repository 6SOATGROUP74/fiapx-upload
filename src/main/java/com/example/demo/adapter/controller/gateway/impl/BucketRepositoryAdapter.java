package com.example.demo.adapter.controller.gateway.impl;

import com.example.demo.adapter.controller.gateway.interfaces.BucketRepositoryAdapterPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;


@Service
public class BucketRepositoryAdapter implements BucketRepositoryAdapterPort {

    @Autowired
    private S3Client amazonS3;

    @Value("${aws.s3.bucketName:teste")
    private String bucketName;


    @Override
    public void upload(MultipartFile file, String email) throws IOException {

        final var put = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(email + "/" + file.getOriginalFilename()).build();

        amazonS3.putObject(put,  RequestBody.fromInputStream(file.getInputStream(), file.getSize()));

    }




}
