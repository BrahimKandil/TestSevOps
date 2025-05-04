package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void testMain() {
        DemoApplication.main(new String[] {});
        assertDoesNotThrow(() -> DemoApplication.main(new String[] {}), "Application context failed to load");

    }

    @Test
    void contextLoads() {
        throw new UnsupportedOperationException("This test is intentionally not implemented");
    }

}
