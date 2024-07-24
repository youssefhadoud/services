package com.youssef.costumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CostumerController(CustomerService customerService) {
@PostMapping
    public void registerCustomer(@RequestBody CustomerRegistationRequest customerRegistationRequest){

log.info("new customer registration {}",customerRegistationRequest);
customerService.register(customerRegistationRequest);
    }
}
