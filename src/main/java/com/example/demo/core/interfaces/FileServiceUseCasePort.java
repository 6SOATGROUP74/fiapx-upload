package com.example.demo.core.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface FileServiceUseCasePort {
    void upload(MultipartFile file) throws IOException;
}
