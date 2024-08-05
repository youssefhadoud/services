package com.youssef.amqp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor

public class RabbitMQMessagingProtocol {

    public final AmqpTemplate amqpTemplate;

    public void publish(Object payload,String exchange,String routingKey){
        log.info("publishing to {} ,using routing key {},and payloadd {}",exchange,routingKey,payload);
        amqpTemplate.convertAndSend(exchange,routingKey,payload);
        log.info("published to {} ,using routing key {},and payloadd {}",exchange,routingKey,payload);


    }
}
