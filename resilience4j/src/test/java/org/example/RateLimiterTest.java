package org.example;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class RateLimiterTest {

    private final AtomicLong counter = new AtomicLong(0L);

    @Test
    void testRateLimiterConfig() {
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitForPeriod(100)
                .limitRefreshPeriod(Duration.ofMinutes(1))
                .timeoutDuration(Duration.ofMinutes(3))
                .build();

        RateLimiter rateLimiter = RateLimiter.of("ichwan", config);

        for (int i = 0; i < 500; i++) {
            Runnable runnable = RateLimiter.decorateRunnable(rateLimiter, () -> {
               long result = counter.incrementAndGet();
                log.info("Result {}", result);
            });

            runnable.run();
        }
    }

    @Test
    void testRateLimiterRegistry() {
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitForPeriod(100)
                .limitRefreshPeriod(Duration.ofMinutes(1))
                .timeoutDuration(Duration.ofMinutes(3))
                .build();

        RateLimiterRegistry registry = RateLimiterRegistry.ofDefaults();
        registry.addConfiguration("config", config);

        RateLimiter rateLimiter = registry.rateLimiter("ichwan", "config");

        for (int i = 0; i < 500; i++) {
            Runnable runnable = RateLimiter.decorateRunnable(rateLimiter, () -> {
                long result = counter.incrementAndGet();
                log.info("Result {}", result);
            });

            runnable.run();
        }
    }
}
