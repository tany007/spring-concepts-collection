package com.example.resilience4j_ratelimiter.controller;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @RateLimiter(name = "backendA")
    @GetMapping("/message/a")
    public String getMessageA() {
        return "Message from backend A";
    }

    @RateLimiter(name = "backendB")
    @GetMapping("/message/b")
    public String getMessageB() {
        return "Message from backend B";
    }

    @RateLimiter(name = "backendC")
    @GetMapping("/message/c")
    public String getMessageC() {
        return "Message from backend C which uses default RateLimiter configuration";
    }
}