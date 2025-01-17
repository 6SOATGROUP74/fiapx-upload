package com.example.demo.service;

import com.example.demo.repository.BucketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    @Autowired
    BucketRepository repository;

    public boolean upload(MultipartFile file) throws Exception {

        try {
            return repository.upload(file);
        }catch (Exception e){
            throw new Exception();
        }
    }

}
