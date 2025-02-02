package com.example.demo.core.impl;

import com.example.demo.adapter.controller.FileController;
import com.example.demo.adapter.controller.gateway.impl.BucketRepositoryAdapter;
import com.example.demo.adapter.controller.gateway.impl.SecurityAdapter;
import com.example.demo.core.interfaces.FileServiceUseCasePort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class FileServiceUseCase implements FileServiceUseCasePort {


    private static final Logger logger = LogManager.getLogger(FileServiceUseCase.class);
    private final BucketRepositoryAdapter repository;
    private final SecurityAdapter securityAdapter;

    public FileServiceUseCase(BucketRepositoryAdapter repository, SecurityAdapter securityAdapter) {
        this.repository = repository;
        this.securityAdapter = securityAdapter;
    }

    @Override
    public void upload(MultipartFile file, String userId) throws IOException {

        logger.info("m=upload, msg=");

        final var response = securityAdapter.consulta(userId);

        repository.upload(file, response.email());
    }
}
