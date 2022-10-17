package com.canvas.service.impl;

import com.canvas.dto.CustomerResponse;
import com.canvas.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerResponse getCustomer(String id) {
        return new CustomerResponse();
    }
}
