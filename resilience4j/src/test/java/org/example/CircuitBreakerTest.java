package org.example;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class CircuitBreakerTest {

    void callMe(){
        log.info("try call me");
        throw new IllegalArgumentException("Error in callMe()");
    }

    @Test
    void testCircuitBreaker() {

        CircuitBreaker braker = CircuitBreaker.ofDefaults("ichwan");

        for (int i = 0; i < 101; i++) {
            try {
                Runnable runnable = CircuitBreaker.decorateRunnable(braker, () -> callMe());
                runnable.run();
            } catch (Exception e){
                //error : CircuitBreaker 'ichwan' is OPEN and does not permit further calls
                log.error("error : {}", e.getMessage());
            }
        }
    }

    @Test
    void testCircuitBreakerConfig() {

        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .failureRateThreshold(10f)
                .slidingWindowSize(10)
                .minimumNumberOfCalls(10)
                .build();

        CircuitBreaker braker = CircuitBreaker.of("ichwan", config);

        for (int i = 0; i < 101; i++) {
            try {
                Runnable runnable = CircuitBreaker.decorateRunnable(braker, () -> callMe());
                runnable.run();
            } catch (Exception e){
                //error : CircuitBreaker 'ichwan' is OPEN and does not permit further calls
                log.error("error : {}", e.getMessage());
            }
        }
    }

    @Test
    void testCircuitBreakerRegistry() {

        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .failureRateThreshold(10f)
                .slidingWindowSize(10)
                .minimumNumberOfCalls(10)
                .build();

        CircuitBreakerRegistry registry = CircuitBreakerRegistry.ofDefaults();
        registry.addConfiguration("config", config);

        CircuitBreaker braker = registry.circuitBreaker("ichwan","config");

        for (int i = 0; i < 101; i++) {
            try {
                Runnable runnable = CircuitBreaker.decorateRunnable(braker, () -> callMe());
                runnable.run();
            } catch (Exception e){
                //error : CircuitBreaker 'ichwan' is OPEN and does not permit further calls
                log.error("error : {}", e.getMessage());
            }
        }
    }
}
