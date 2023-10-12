package org.example;

import io.github.resilience4j.retry.Retry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class RetryTest {

    void callMe(){
        log.info("try call me");
        throw new IllegalArgumentException("Error in callMe()");
    }

    @Test
    void testRetry() {
        Retry retry = Retry.ofDefaults("ichwan");

        //jika method callMe() mengembalikan nilai, gunakan decorateSupplier()
        Runnable runnable = Retry.decorateRunnable(retry, () -> callMe());
        runnable.run();
    }
}
