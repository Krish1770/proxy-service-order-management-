package com.example.proxyservice.FeignClients;

import com.example.proxyservice.dto.BillDto;
import com.example.proxyservice.dto.GenerateMailDTO;
import com.example.proxyservice.dto.ResponseDTO;
import jakarta.mail.MessagingException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.CompletableFuture;

@FeignClient(name = "BILL-SERVICE",url = "http://localhost:8081")
public interface BillCollaboration {



    @PostMapping("Bill")
  ResponseEntity<ResponseDTO>createBills(@RequestBody BillDto billDto) throws MessagingException;

    @PostMapping("Bill/health")
    String health();
}
