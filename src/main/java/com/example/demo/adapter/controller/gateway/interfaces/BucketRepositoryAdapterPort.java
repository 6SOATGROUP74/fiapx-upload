package com.example.demo.adapter.controller.gateway.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface BucketRepositoryAdapterPort {
    void upload(MultipartFile file) throws IOException;
}
