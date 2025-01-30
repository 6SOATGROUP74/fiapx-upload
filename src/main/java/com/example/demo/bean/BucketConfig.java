package com.example.demo.bean;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
@Profile("prod")
public class BucketConfig {

    @Bean
    public S3Client config() {
        return S3Client.builder().region(Region.US_EAST_1)
                .forcePathStyle(true).build();

    }
}
