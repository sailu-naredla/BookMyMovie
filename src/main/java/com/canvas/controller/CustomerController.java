package com.canvas.controller;

import com.canvas.dto.CityResponse;
import com.canvas.dto.CustomerResponse;
import com.canvas.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping(value = "/api/v1/customer")
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{customer_id}")
    public ResponseEntity<Object> get(@PathVariable("customer_id") String customerId) {
        CustomerResponse customerResponse = customerService.getCustomer(customerId);
        ResponseEntity<Object> response =  new ResponseEntity<>(customerResponse, HttpStatus.OK);
        return response;
    }
}
