package com.youssef.fraud;

import com.youssef.fraud.entity.FraudCheckHistory;
import com.youssef.fraud.repo.FraudRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class FraudCheckService {

    private final FraudRepository  fraudRepository;
    public boolean isfraudulentCustomer(Integer customerId){
        fraudRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .createdAt(LocalDateTime.now())
                        .isFraud(false)
                        .build()
        );
        log.info("new fraud resiter ");
        return false;
    }
}
