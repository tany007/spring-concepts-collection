package com.example.asynchronous.controller;

import com.example.asynchronous.dto.Order;
import com.example.asynchronous.service.OrderFulfillmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderFulfillmentController {

    @Autowired
    private OrderFulfillmentService orderFulfillmentService;

    @PostMapping
    public ResponseEntity<Order> processOrder(@RequestBody Order order) throws InterruptedException {
        orderFulfillmentService.processOrder(order); // synchronous processing

        // Asynchronous tasks
        orderFulfillmentService.notifyUser(order);
        orderFulfillmentService.assignVendor(order);
        orderFulfillmentService.packageOrder(order);
        orderFulfillmentService.assignDeliveryPartner(order);
        orderFulfillmentService.assignTrailerAndDispatch(order);
        return ResponseEntity.ok(order);
    }

}
