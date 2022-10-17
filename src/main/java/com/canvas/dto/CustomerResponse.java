package com.canvas.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerResponse {
    private List<Customer> customers;
}
