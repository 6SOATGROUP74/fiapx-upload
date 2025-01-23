package com.example.demo.core.impl;

import com.example.demo.adapter.controller.gateway.impl.BucketRepositoryAdapter;
import com.example.demo.core.interfaces.FileServiceUseCasePort;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class FileServiceUseCase implements FileServiceUseCasePort {

    private final BucketRepositoryAdapter repository;

    public FileServiceUseCase(BucketRepositoryAdapter repository) {
        this.repository = repository;
    }

    @Override
    public void upload(MultipartFile file) throws IOException {
        repository.upload(file);
    }
}
