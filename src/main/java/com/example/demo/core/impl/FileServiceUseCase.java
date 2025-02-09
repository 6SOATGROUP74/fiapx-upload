package com.example.demo.core.impl;

import ch.qos.logback.core.util.ContentTypeUtil;
import com.example.demo.adapter.controller.FileController;
import com.example.demo.adapter.controller.gateway.impl.BucketRepositoryAdapter;
import com.example.demo.adapter.controller.gateway.impl.SecurityAdapter;
import com.example.demo.core.interfaces.FileServiceUseCasePort;
import com.example.demo.exception.TipoDeArquivoException;
import jdk.jfr.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class FileServiceUseCase implements FileServiceUseCasePort {


    private static final Logger logger = LogManager.getLogger(FileServiceUseCase.class);
    private final BucketRepositoryAdapter repository;
    private final SecurityAdapter securityAdapter;
    private static final String ALLOWED_CONTENT_TYPE = "video/mp4";

    public FileServiceUseCase(BucketRepositoryAdapter repository, SecurityAdapter securityAdapter) {
        this.repository = repository;
        this.securityAdapter = securityAdapter;
    }

    @Override
    public void upload(MultipartFile file, String userId) throws IOException {

        logger.info("m=upload, msg=");

            if(!ALLOWED_CONTENT_TYPE.equals(file.getContentType())){
                throw new TipoDeArquivoException("Tipo de arquivo nao suportado");
            }

            final var response = securityAdapter.consulta(userId);

            repository.upload(file, response.email());

    }
}
