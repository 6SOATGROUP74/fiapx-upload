package com.example.demo.bean;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
@Profile("prod")
public class BucketConfig {

    @Value("${aws.accessKey}")
    private String accessKey;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Value("${aws.sessionToken}")
    private String sessionToken;

    private AwsSessionCredentials buildCredential(){
        return AwsSessionCredentials.builder().accessKeyId(accessKey).secretAccessKey(secretKey).sessionToken(sessionToken).build();
    }

    @Bean
    public S3Client config() {
        return S3Client.builder().region(Region.US_EAST_1)
                .credentialsProvider(this::buildCredential)
                .forcePathStyle(true).build();

    }
}
