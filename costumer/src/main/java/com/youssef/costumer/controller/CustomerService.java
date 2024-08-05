package com.youssef.costumer.controller;

import com.youssef.amqp.RabbitMQMessagingProtocol;
import com.youssef.clients.fraud.FraudCheckResponce;
import com.youssef.clients.fraud.FraudClients;
import com.youssef.clients.notification.NotificationClient;
import com.youssef.clients.notification.NotificationRequest;
import com.youssef.costumer.module.Customer;
import com.youssef.costumer.repository.CustomerRepo;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public record CustomerService(RabbitMQMessagingProtocol rabbitMQMessagingProtocol, CustomerRepo customerRepo, RestTemplate restTemplate, NotificationClient notificationClient, FraudClients fraudClients) {

    public void register(CustomerRegistationRequest request) {
        Customer customer=Customer.builder()
                .name(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //todo: check if email valid
        // todo : check if email not token
        customerRepo.saveAndFlush(customer);


        FraudCheckResponce fraudCheckResponce=fraudClients.isFraudster(customer.getId());


        if(fraudCheckResponce.isFraudster()){
            throw new IllegalStateException("fraudster");
        }


// todo: add the async to this part with queu

        rabbitMQMessagingProtocol.publish(new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi sir %s you have a notification ",customer.getName())
        ),"internal.exchange","internal.notification.routing-key");



    }
}
