package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoApplicationTests {

    @Test
     void applicationStarts() {
        DemoApplication.main(new String[] {});
    }

    @Test
    void contextLoads() {
        // Ensures Spring context loads — required by @SpringBootTest
        assertTrue(true); // Or any lightweight assertion
    }

}
