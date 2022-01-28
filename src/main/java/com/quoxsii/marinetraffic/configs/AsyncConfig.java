package com.quoxsii.marinetraffic.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncConfig.class);

    @Bean (name = "taskExecutor")
    // Прикольный конфиг, но почему ты решил определить именно эти параметры?
    // Да и зачем тебе здесь конфиг Executor'а ?
    public Executor taskExecutor() {
        LOGGER.debug("Creating Async Task Executor");
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(4);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("ParserThread-");
        executor.initialize();
        return executor;
    }
}
