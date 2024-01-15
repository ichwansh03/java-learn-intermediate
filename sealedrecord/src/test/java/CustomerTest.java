import org.junit.jupiter.api.Test;

import java.lang.reflect.RecordComponent;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void test() {
        Customer customer = new Customer(1L, "John");
        assertEquals(1L, customer.id());
        assertEquals("John", customer.name());
        assertNull(customer.email());

        RecordComponent[] recordComponents = customer.getClass().getRecordComponents();
        assertEquals(4, recordComponents.length);
    }
}