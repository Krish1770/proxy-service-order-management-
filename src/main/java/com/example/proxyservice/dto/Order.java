package com.example.proxyservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Order implements Serializable {

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("orderedDate")
    private Date orderedDate;

}