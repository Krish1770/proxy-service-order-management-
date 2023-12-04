package com.example.proxyservice.api;


import com.example.proxyservice.dto.*;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("Proxy")
public interface ProxyApi {

    @PostMapping()
    public ResponseEntity<ResponseDTO> createBills(@RequestBody  BillDto billDto) throws MessagingException, ExecutionException, InterruptedException;

    @PostMapping("/mailGeneration")
    public void generateMail(@RequestBody GenerateMailDTO generateMailDTO);
}
