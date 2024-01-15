import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void test() {
        Customer customer = new Customer(1L, "John");
        assertEquals(1L, customer.id());
        assertEquals("John", customer.name());
        assertNull(customer.email());
    }
}