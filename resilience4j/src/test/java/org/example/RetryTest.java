package org.example;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.function.Supplier;

@Slf4j
public class RetryTest {

    void callMe(){
        log.info("try call me");
        throw new IllegalArgumentException("Error in callMe()");
    }

    String sayHello(){
        log.info("try say hello");
        throw new IllegalArgumentException("Error in sayHello()");
    }

    @Test
    void testRetry() {
        Retry retry = Retry.ofDefaults("ichwan");

        //jika method callMe() mengembalikan nilai, gunakan decorateSupplier()
        Runnable runnable = Retry.decorateRunnable(retry, () -> callMe());
        runnable.run();
    }

    @Test
    void testRetryConfig(){
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(5)
                .waitDuration(Duration.ofSeconds(1))
                .retryExceptions(IllegalArgumentException.class)
                .ignoreExceptions(RuntimeException.class)
                .build();

        Retry retry = Retry.of("ichwan", config);

        Supplier<String> supplier = Retry.decorateSupplier(retry, () -> sayHello());
        supplier.get();
    }
}
