package com.youssef.notification;

import com.youssef.amqp.RabbitMQMessagingProtocol;
import com.youssef.notification.rabbitmq.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "com.youssef.notification",
                "com.youssef.amqp"
        }
)
@EnableFeignClients(basePackages = "com.youssef.notification")
public class NotificationApplication {
    public static void main(String[] args) {

        SpringApplication.run(NotificationApplication.class,args);

    }

//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessagingProtocol rabbitMQMessagingProtocol, NotificationConfig notificationConfig){
//        return args -> {
//            rabbitMQMessagingProtocol.publish("hi sire",
//            notificationConfig.getInternalExchange(),
//            notificationConfig.getInternalRoutingKey());
//        };
//    }
}
