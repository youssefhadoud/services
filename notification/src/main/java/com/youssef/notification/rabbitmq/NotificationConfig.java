package com.youssef.notification.rabbitmq;


import lombok.Data;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class NotificationConfig {

    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;
    @Value("${rabbitmq.queue.notification}")
    private String notificationQueue;
    @Value("${rabbitmq.routing-key.internal-notification}")
    private String internalRoutingKey;


    @Bean
    public TopicExchange topicExchange(){

        return new TopicExchange(this.internalExchange);
    }
@Bean
    public Queue notificationQueue(){
        return new Queue(this.notificationQueue);

    }
    @Bean
    public Binding internalToNotificationBinding(){
        return BindingBuilder.bind(notificationQueue())
                .to(topicExchange())
                .with(this.internalRoutingKey);
    }




}
