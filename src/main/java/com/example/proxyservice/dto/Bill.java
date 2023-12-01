package com.example.proxyservice.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill implements Serializable {


    @JsonProperty("billId")
    private String id;

    private String userName;

    @JsonProperty("order")
    private Order order;

    @JsonProperty("orderItems")
    private List<ResponseOrderItems> orderItems;
}
