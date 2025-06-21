package com.example.dynamicbean.service.impl;

import com.example.dynamicbean.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("upi")
public class UpiPaymentService implements PaymentService {

    @Override
    public String pay(String amount, String mode, String sender, String receiver) {
        return "UPI Payment of " + amount + " from " + sender + " to " + receiver + " using mode: " + mode;
    }
}
