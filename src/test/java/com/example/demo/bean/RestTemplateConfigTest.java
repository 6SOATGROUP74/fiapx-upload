package com.example.demo.bean;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestTemplateConfigTest {

    @InjectMocks
    private RestTemplateConfig restTemplateConfig;

    @Mock
    private RestTemplateBuilder restTemplateBuilder;

    @Test
    void testBuildRestTemplate() {
        RestTemplate restTemplate = restTemplateConfig.buildRestTemplate();
        assertThat(restTemplate).isNotNull();
    }
}
