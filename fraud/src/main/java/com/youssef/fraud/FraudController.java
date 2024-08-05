package com.youssef.fraud;

import com.youssef.clients.fraud.FraudCheckResponce;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {
    private FraudCheckService fraudCheckService;
    @GetMapping ("{customerId}")
    public FraudCheckResponce isFraudster(@PathVariable("customerId") Integer customerId){
        boolean isFraudcheckpass=fraudCheckService.isfraudulentCustomer(customerId);
        log.info("new froud check {}",customerId);
        return new FraudCheckResponce(isFraudcheckpass);

    }
}
