package com.example.demo.bean;

import com.example.demo.adapter.controller.gateway.impl.BucketRepositoryAdapter;
import com.example.demo.core.impl.FileServiceUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public FileServiceUseCase incluirClienteUseCasePort(BucketRepositoryAdapter adapterPort) {
        return new FileServiceUseCase(adapterPort);
    }

}
