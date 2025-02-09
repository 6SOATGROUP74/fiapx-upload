package com.example.demo.adapter.controller;

import com.example.demo.core.interfaces.FileServiceUseCasePort;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

class FileControllerTest {

    private MockMvc mockMvc;

    @Mock
    FileServiceUseCasePort useCasePort;

    @InjectMocks
    FileController fileController;

    AutoCloseable openMocks;


    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(fileController)
                //.setControllerAdvice(new CustomExceptionHandlers())
                .addFilter((request, response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                }, "/*")
                .build();
    }


}