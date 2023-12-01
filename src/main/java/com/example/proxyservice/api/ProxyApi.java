package com.example.proxyservice.api;


import com.example.proxyservice.dto.*;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.CompletableFuture;

@RequestMapping("Proxy")
public interface ProxyApi {

    @PostMapping()
    public CompletableFuture<ResponseEntity<ResponseDTO>> createBills(@RequestBody  BillDto billDto) throws MessagingException;

    @PostMapping("/mailGeneration")
    public void generateMail(@RequestBody GenerateMailDTO generateMailDTO);
}
