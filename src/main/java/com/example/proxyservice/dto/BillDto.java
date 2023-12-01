package com.example.proxyservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDto {

    @JsonProperty("userName")
    private String userName;

    private Order order;

    private List<OrderItems> orderItems;

    private List<BigDecimal> gstList;

    private String emailId;
}
