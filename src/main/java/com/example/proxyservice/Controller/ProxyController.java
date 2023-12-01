package com.example.proxyservice.Controller;

import com.example.proxyservice.api.ProxyApi;
import com.example.proxyservice.dto.*;
import com.example.proxyservice.service.ProxyService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class ProxyController implements ProxyApi {

    @Autowired
    private ProxyService proxyService;

    @Override
    public CompletableFuture<ResponseEntity<ResponseDTO>> createBills(BillDto billDto) throws MessagingException {
       return proxyService.createBills(billDto);
    }

    @Override
    public void generateMail(GenerateMailDTO generateMailDTO) {
   proxyService.generateMail(generateMailDTO);
    }

}
