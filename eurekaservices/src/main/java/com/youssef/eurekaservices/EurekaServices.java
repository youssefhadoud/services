package com.youssef.eurekaservices;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServices {
    public static void main(String[] args){
        SpringApplication.run(EurekaServices.class,args);
    }
}
