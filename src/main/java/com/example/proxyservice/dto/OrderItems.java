package com.example.proxyservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItems implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("item")
    private ReceivedItems item;

    @JsonProperty("quantity")
    private Long quantity;

    @JsonProperty("amount")
    private Long amount;
}