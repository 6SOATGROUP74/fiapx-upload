package com.example.demo.bean;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.adapter.controller.gateway.impl.BucketRepositoryAdapter;
import com.example.demo.adapter.controller.gateway.impl.SecurityAdapter;
import com.example.demo.core.impl.FileServiceUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BeanConfigTest {

    @Mock
    private BucketRepositoryAdapter bucketRepositoryAdapter;

    @Mock
    private SecurityAdapter securityAdapter;

    @InjectMocks
    private BeanConfig beanConfig;

    @Test
    void testIncluirClienteUseCasePort() {
        FileServiceUseCase fileServiceUseCase = beanConfig.incluirClienteUseCasePort(bucketRepositoryAdapter, securityAdapter);
        assertThat(fileServiceUseCase).isNotNull();
    }
}
