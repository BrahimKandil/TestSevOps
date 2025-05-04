package com.example.demo;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testNoArgConstructorAndSettersAndGetters() {
        User user = new User();
        user.setId(1L);
        user.setName("Alice");

        // Explicitly call Lombok-generated getters
        Long id = user.getId();
        String name = user.getName();

        assertEquals(1L, id);
        assertEquals("Alice", name);
    }

    @Test
    void testAllArgsConstructorAndGetters() {
        User user = new User(2L, "Bob");

        assertEquals(2L, user.getId());
        assertEquals("Bob", user.getName());
    }

    @Test
    void testNameOnlyConstructorAndGetters() {
        User user = new User("Charlie");

        assertNull(user.getId()); // ID should be null before persistence
        assertEquals("Charlie", user.getName());
    }
}