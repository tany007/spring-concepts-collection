package com.example.dynamicbean.Controller;

import com.example.dynamicbean.model.PaymentRequest;
import com.example.dynamicbean.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private Map<String, PaymentService> paymentServiceMap;

    /*public PaymentController(Map<String, PaymentService> paymentServiceMap) {
        this.paymentServiceMap = paymentServiceMap;
    }*/

    @PostMapping("/pay")
    public String pay(@RequestBody PaymentRequest paymentRequest) {
        String paymentMode = paymentRequest.getMode().toLowerCase();
        PaymentService paymentService = paymentServiceMap.get(paymentMode);

        if (paymentService == null) {
            throw new IllegalArgumentException("Unsupported payment mode: " + paymentMode);
        }

        return paymentService.pay(
                paymentRequest.getAmount(),
                paymentMode,
                paymentRequest.getSender(),
                paymentRequest.getReceiver()
        );
    }
}
