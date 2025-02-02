package com.example.demo.adapter.controller;

import com.example.demo.core.interfaces.FileServiceUseCasePort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller("/file")
public class FileController {

    final FileServiceUseCasePort fileServiceUseCasePort;

    public FileController(FileServiceUseCasePort fileServiceUseCasePort) {
        this.fileServiceUseCasePort = fileServiceUseCasePort;
    }

    private static final Logger logger = LogManager.getLogger(FileController.class);

    @PostMapping
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file, @AuthenticationPrincipal Jwt jwt) throws Exception {

        logger.info("m=handleFileUpload, msg=Req de upload recebida={}", file.getOriginalFilename());

        fileServiceUseCasePort.upload(file, (String) jwt.getClaims().get("sub"));

        logger.info("m=handleFileUpload, msg=upload efetuado com sucesso");

        return ResponseEntity.accepted().build();
    }

}
