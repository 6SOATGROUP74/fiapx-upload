package com.example.demo.adapter.controller;

import com.example.demo.core.interfaces.FileServiceUseCasePort;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) throws Exception {

        fileServiceUseCasePort.upload(file);

        return ResponseEntity.accepted().build();
    }

}
