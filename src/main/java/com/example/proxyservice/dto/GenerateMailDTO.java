package com.example.proxyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateMailDTO {
    private String emailId;

    private Bill bill;

    private String id;
}
