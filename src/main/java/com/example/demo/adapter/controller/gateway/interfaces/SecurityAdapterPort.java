package com.example.demo.adapter.controller.gateway.interfaces;

import com.example.demo.adapter.controller.gateway.domain.UserResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface SecurityAdapterPort {
    UserResponse consulta(String userId);
    String buildToken();

}
