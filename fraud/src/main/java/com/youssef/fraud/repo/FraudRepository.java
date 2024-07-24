package com.youssef.fraud.repo;

import com.youssef.fraud.entity.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepository extends JpaRepository<FraudCheckHistory,Integer> {
}
