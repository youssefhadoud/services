package com.youssef.costumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;

@SpringBootApplication

public class CustomerApplication {
    public static void main(String[] args){
        SpringApplication.run(CustomerApplication.class,args);

    }
}
