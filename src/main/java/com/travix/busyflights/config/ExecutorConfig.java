package com.travix.busyflights.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutorConfig {

    private int corePoolSize;
    private int maximumPoolSize;
    private int keepAliveTime;

    public ExecutorConfig(@Value("${executor.service.corepoolsize}")
                                        int corePoolSize,
                                        @Value("${executor.service.maximumpoolsize}")
                                        int maximumPoolSize,
                                        @Value("${executor.service.keepalivetime}")
                                        int keepAliveTime) {

        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
    }

    @Bean
    public ExecutorService executorService() {
        return new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(maximumPoolSize));
    }
}
