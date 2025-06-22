package com.example.asynchronous.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean("asyncTaskExecutor")
    public Executor asyncTaskExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // Minimum number of threads
        executor.setQueueCapacity(10); // Queue size for tasks waiting to be executed
        executor.setMaxPoolSize(8); // Maximum number of threads
        executor.setThreadNamePrefix("AsyncExecutor-"); // Prefix for thread names
        executor.initialize(); // Initialize the executor
        return executor;
    }

}
