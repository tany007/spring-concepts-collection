package com.example.asynchronous.service;

import com.example.asynchronous.dto.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class OrderFulfillmentService {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private PaymentService paymentService;

    /* All Required methods for order fulfillment */
    /*
      1. Inventory service check order availability
      2. Process payment for order
      3. Notify to the user
      3. Assign to vendor
      4. packaging
      5. assign delivery partner
      6. assign trailer
      7. dispatch product
      **/

    public Order processOrder(Order order) {
        order.setTrackingNumber(UUID.randomUUID().toString());
        if(inventoryService.checkProductAvailability(order.getProductId(), order.getQuantity())){
            paymentService.processPayment(order);
        }
        else {
            throw new RuntimeException("Technical issue, please try again later.");
        }
        return order;
    }

    @Async("asyncTaskExecutor")
    public void notifyUser(Order order) throws InterruptedException {
        // Simulate notifying the user
        Thread.sleep(4000L);
        System.out.println("Notification sent to user for Order ID: " + order.getOrderId() +
                ", Product: " + order.getProductName() +
                ", Tracking Number: " + order.getTrackingNumber());
        log.info("Notified to the user " + Thread.currentThread().getName());
    }

    @Async("asyncTaskExecutor")
    public void assignVendor(Order order) throws InterruptedException {
        // Simulate assigning a vendor
        Thread.sleep(5000L);
        System.out.println("Vendor assigned for Order ID: " + order.getOrderId() +
                ", Product: " + order.getProductName());
        log.info("Assign order to vendor " + Thread.currentThread().getName());
    }

    @Async("asyncTaskExecutor")
    public void packageOrder(Order order) throws InterruptedException {
        // Simulate packaging the order
        Thread.sleep(3000L);
        System.out.println("Order packaged for Order ID: " + order.getOrderId() +
                ", Product: " + order.getProductName());
        log.info("Order packaging completed " + Thread.currentThread().getName());
    }

    @Async("asyncTaskExecutor")
    public void assignDeliveryPartner(Order order) throws InterruptedException {
        // Simulate assigning a delivery partner
        Thread.sleep(2000L);
        System.out.println("Delivery partner assigned for Order ID: " + order.getOrderId() +
                ", Product: " + order.getProductName());
        log.info("Delivery partner assigned " + Thread.currentThread().getName());
    }

    @Async("asyncTaskExecutor")
    public void assignTrailerAndDispatch(Order order) throws InterruptedException {
        // Simulate assigning a trailer
        Thread.sleep(1000L);
        System.out.println("Trailer assigned and product dispatched for Order ID: " + order.getOrderId() +
                ", Product: " + order.getProductName());
        log.info("Trailer assigned and Order dispatched " + Thread.currentThread().getName());
    }
}
