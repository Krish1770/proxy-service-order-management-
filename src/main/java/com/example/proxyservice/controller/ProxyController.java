package com.example.proxyservice.controller;

import com.example.proxyservice.api.ProxyApi;
import com.example.proxyservice.dto.*;
import com.example.proxyservice.service.ProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController implements ProxyApi {

    @Autowired
    private ProxyService proxyService;

    @Override
    public ResponseEntity<ProxyResponseDTO> createBills(BillDto billDto) {

        try {
            ResponseEntity<ProxyResponseDTO> res = proxyService.createBills(billDto);
            System.out.println("controller");
            System.out.println("result  " + res);
            return res;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ProxyResponseDTO("Exception occured", "", HttpStatus.NOT_FOUND));
        }
    }
    @Override
    public void generateMail(GenerateMailDTO generateMailDTO) {
   proxyService.generateMail(generateMailDTO);
    }

}
