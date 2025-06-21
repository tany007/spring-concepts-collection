package com.example.dynamicbean.model;

public class PaymentRequest {

    private String amount;
    private String mode;
    private String sender;
    private String receiver;

    public PaymentRequest(String amount, String mode, String sender, String receiver) {
        this.amount = amount;
        this.mode = mode;
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getAmount() {
        return amount;
    }

    public String getMode() {
        return mode;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }
}
