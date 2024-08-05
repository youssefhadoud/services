package com.youssef.eurekaservices;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableEurekaServer

public class EurekaServices {
    public static void main(String[] args){
        SpringApplication.run(EurekaServices.class,args);
    }
}
