package com.youssef.clients.fraud;

import org.springframework.stereotype.Component;

@Component
public record FraudCheckResponce(boolean isFraudster) {
}
