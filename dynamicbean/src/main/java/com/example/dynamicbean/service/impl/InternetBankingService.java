package com.example.dynamicbean.service.impl;

import com.example.dynamicbean.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("internetbanking")
public class InternetBankingService implements PaymentService {

    @Override
    public String pay(String amount, String mode, String sender, String receiver) {
        // Implement the logic for Internet Banking payment processing
        return "Internet Banking Payment of " + amount + " from " + sender + " to " + receiver + " using mode: " + mode;
    }
}
