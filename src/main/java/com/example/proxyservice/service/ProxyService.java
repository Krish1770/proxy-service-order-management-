package com.example.proxyservice.service;

import com.example.proxyservice.dto.BillDto;
import com.example.proxyservice.dto.GenerateMailDTO;
import com.example.proxyservice.dto.OrderDTO;
import com.example.proxyservice.dto.ResponseDTO;
import jakarta.mail.MessagingException;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
public interface ProxyService {
    public CompletableFuture<ResponseEntity<ResponseDTO>> createBills(BillDto billDto) throws MessagingException;

    void generateMail(GenerateMailDTO generateMailDTO);
}
