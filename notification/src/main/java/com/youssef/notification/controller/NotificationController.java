package com.youssef.notification.controller;

import com.youssef.clients.notification.NotificationRequest;
import com.youssef.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/notification")
@AllArgsConstructor
@Slf4j
public class NotificationController {
//   private  NotificationService notificationService;
// @PostMapping
//    public void sendNotification(@RequestBody NotificationRequest notificationRequest){
//     log.info("new registration {}",notificationRequest);
//
//        notificationService.send(notificationRequest);
//
//    }
}
