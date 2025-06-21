package com.example.dynamicbean.service.impl;

import com.example.dynamicbean.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("creditcard")
public class CreditCardService implements PaymentService {

    @Override
    public String pay(String amount, String mode, String sender, String receiver) {
        return "Credit Card Payment of " + amount + " from " + sender + " to " + receiver + " using mode: " + mode;
    }
}
