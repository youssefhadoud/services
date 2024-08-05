package com.youssef.notification.controller;

import com.youssef.clients.notification.NotificationRequest;
import com.youssef.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class NotificationListner {
    private final NotificationService notificationService;
    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void listner(NotificationRequest notificationRequest){
log.info("the cunsumer consume from the queue {}",notificationRequest);
        notificationService.send(notificationRequest);
    }
}
