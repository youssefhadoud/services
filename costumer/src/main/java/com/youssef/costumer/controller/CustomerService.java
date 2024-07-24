package com.youssef.costumer.controller;

import com.youssef.costumer.module.Customer;
import com.youssef.costumer.repository.CustomerRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public record CustomerService(CustomerRepo customerRepo,RestTemplate restTemplate) {

    public void register(CustomerRegistationRequest request) {
        Customer customer=Customer.builder()
                .name(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //todo: check if email valid
        // todo : check if email not token
        customerRepo.saveAndFlush(customer);
        log.info("new registeration {}",customer.getId());


        FraudCheckResponce fraudCheckResponce=restTemplate.getForObject(
          "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponce.class,
                customer.getId()

        );

        if(fraudCheckResponce.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
    }
}
