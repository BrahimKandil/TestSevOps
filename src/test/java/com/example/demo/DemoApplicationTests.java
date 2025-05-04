package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        // Verify Spring context loads
        assertTrue(true, "Context should load successfully");
    }

    @Test
    void testMainMethod() {
        // Test main method execution
        assertDoesNotThrow(() -> DemoApplication.main(new String[] {}));
    }

    @Test
    void testMainMethodWithArgs() {
        // Test with command line arguments
        assertDoesNotThrow(() -> DemoApplication.main(new String[] {"--spring.profiles.active=test"}));
    }

}
