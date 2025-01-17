package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


@Service
public class BucketRepository {


    @Autowired
    S3Client amazonS3;

    public boolean upload(MultipartFile file) throws IOException {

        File conv = new File(file.getOriginalFilename());
        FileOutputStream out = new FileOutputStream(conv);
        out.write(file.getBytes());
        out.close();


        final var put = PutObjectRequest.builder()
                .bucket("bucket-teste-fiap-15-01")
                .key("concat/" + file.getOriginalFilename()).build();



        amazonS3.putObject(put,  RequestBody.fromFile(conv));



        return true;

    }




}
