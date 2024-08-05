package com.youssef.notification.service;

import com.youssef.clients.notification.NotificationRequest;
import com.youssef.notification.entity.Notify;
import com.youssef.notification.repo.NotificationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepo notificationRepo;
    public void send(NotificationRequest notificationRequest){
        notificationRepo.save(Notify.builder()
                        .customerId(notificationRequest.customerId())
                        .custumerEmail(notificationRequest.email())
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())

                .build());
    }
}
