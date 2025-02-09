package com.example.demo.adapter.controller;

import com.example.demo.core.interfaces.FileServiceUseCasePort;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
                .setControllerAdvice(new CustomExceptionHandlers())
                .addFilter((request, response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                }, "/*")
                .build();
    }

/*
    @Test
    void devePermitirIncluirArquivo() throws Exception {

        String content = "Conteúdo fictício do arquivo de teste";
        byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);

        var teste = new MockMultipartFile("file", "teste.mp4", "video/mp4", contentBytes);

        mockMvc.perform(MockMvcRequestBuilders.multipart("/upload")
                .file(teste)
                .param("file", "4"))
                .andDo(print())
                .andExpect(status().isCreated());
        verify(useCasePort, times(1))
                .upload(teste, anyString());
    }
*/

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}