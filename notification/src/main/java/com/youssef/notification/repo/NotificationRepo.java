package com.youssef.notification.repo;

import com.youssef.notification.entity.Notify;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notify,Integer> {
}
