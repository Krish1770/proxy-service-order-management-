package com.example.proxyservice.service;

import com.example.proxyservice.dto.BillDto;
import com.example.proxyservice.dto.GenerateMailDTO;
import com.example.proxyservice.dto.ProxyResponseDTO;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;


@Service
public interface ProxyService {
    public ResponseEntity<ProxyResponseDTO> createBills(BillDto billDto) throws MessagingException, ExecutionException, InterruptedException;

    void generateMail(GenerateMailDTO generateMailDTO);
}
