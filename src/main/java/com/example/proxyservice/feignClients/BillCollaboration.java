package com.example.proxyservice.feignClients;

import com.example.proxyservice.dto.BillDto;
import com.example.proxyservice.dto.ProxyResponseDTO;
import jakarta.mail.MessagingException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "BILL-SERVICE",url = "http://localhost:8081")
public interface BillCollaboration {



    @PostMapping("Bill")
  ResponseEntity<ProxyResponseDTO>createBills(@RequestBody BillDto billDto) throws MessagingException;

    @PostMapping("Bill/health")
    String health();
}
