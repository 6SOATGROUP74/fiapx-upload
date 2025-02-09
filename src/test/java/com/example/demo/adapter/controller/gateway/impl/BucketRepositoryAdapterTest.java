package com.example.demo.adapter.controller.gateway.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BucketRepositoryAdapterTest {

    @Mock
    private S3Client amazonS3;

    @InjectMocks
    private BucketRepositoryAdapter bucketRepositoryAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUpload() throws IOException {
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "test.txt",
                "text/plain",
                "Hello World".getBytes()
        );

        String email = "user@example.com";

        bucketRepositoryAdapter.upload(file, email);

        ArgumentCaptor<PutObjectRequest> putObjectCaptor = ArgumentCaptor.forClass(PutObjectRequest.class);
        ArgumentCaptor<RequestBody> requestBodyCaptor = ArgumentCaptor.forClass(RequestBody.class);

        verify(amazonS3, times(1)).putObject(putObjectCaptor.capture(), requestBodyCaptor.capture());

        PutObjectRequest capturedRequest = putObjectCaptor.getValue();
        assertEquals(email + "/test.txt", capturedRequest.key());

        RequestBody capturedBody = requestBodyCaptor.getValue();
    }
}
