package com.example.proxyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProxyResponseDTO {
    private String message;

    private Object Data;

    private HttpStatus status;
}
