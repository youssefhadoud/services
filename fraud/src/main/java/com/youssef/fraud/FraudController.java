package com.youssef.fraud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {
    private FraudCheckService fraudCheckService;
    @GetMapping ("{customerId}")
    public FraudCheckResponce isFraudster(@PathVariable("customerId") Integer customerId){
        boolean isFraudcheckpass=fraudCheckService.isfraudulentCustomer(customerId);
        return new FraudCheckResponce(isFraudcheckpass);

    }
}
