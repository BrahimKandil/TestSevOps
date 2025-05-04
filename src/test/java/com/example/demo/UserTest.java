package com.example.demo;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testNoArgConstructor() {
        User user = new User();
        user.setId(1L);
        user.setName("Alice");

        // Explicitly call Lombok-generated getters
        assertEquals(1L, user.getId());
        assertEquals("Alice", user.getName());
    }

    @Test
    void testAllArgsConstructor() {
        User user = new User(2L, "Bob");

        assertEquals(2L, user.getId());
        assertEquals("Bob", user.getName());
    }

    @Test
    void testNameOnlyConstructor() {
        User user = new User("Charlie");

        assertNull(user.getId()); // ID should be null before persistence
        assertEquals("Charlie", user.getName());
    }
}