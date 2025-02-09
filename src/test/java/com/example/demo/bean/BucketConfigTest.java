package com.example.demo.bean;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.services.s3.S3Client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BucketConfigTest {

    @Mock
    private AwsSessionCredentials awsSessionCredentials;

    @InjectMocks
    private BucketConfig bucketConfig;

    @Test
    void testConfig() {
        S3Client s3Client = bucketConfig.config();
        assertThat(s3Client).isNotNull();
    }
}
