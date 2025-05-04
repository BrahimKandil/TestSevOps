package com.example.demo;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("Test no-args constructor and default values")
    void testNoArgConstructor() {
        User user = new User();

        assertAll(
                () -> assertNull(user.getId(), "ID should be null initially"),
                () -> assertNull(user.getName(), "Name should be null initially")
        );
    }

    @Test
    @DisplayName("Test all-args constructor")
    void testAllArgsConstructor() {
        Long expectedId = 1L;
        String expectedName = "Alice";
        User user = new User(expectedId, expectedName);

        assertAll(
                () -> assertEquals(expectedId, user.getId(), "ID should match constructor arg"),
                () -> assertEquals(expectedName, user.getName(), "Name should match constructor arg")
        );
    }
    @Test
    @DisplayName("Test name-only constructor")
    void testUser() {
        String expectedName = "Bob";
        User user = new User(expectedName);

        assertAll(
                () -> assertNull(user.getId(), "ID should be null in name-only constructor"),
                () -> assertEquals(expectedName, user.getName(), "Name should match constructor arg")
        );
    }
    @Test
    @DisplayName("Test name-only constructor")
    void testNameOnlyConstructor() {
        String expectedName = "Bob";
        User user = new User(expectedName);

        assertAll(
                () -> assertNull(user.getId(), "ID should be null in name-only constructor"),
                () -> assertEquals(expectedName, user.getName(), "Name should match constructor arg")
        );
    }

    @Test
    @DisplayName("Test field assignments via reflection")
    void testFieldAssignments() throws Exception {
        User user = new User(2L, "Charlie");

        Field idField = User.class.getDeclaredField("id");
        idField.setAccessible(true);
        assertEquals(2L, idField.get(user), "ID field should be set via reflection");

        Field nameField = User.class.getDeclaredField("name");
        nameField.setAccessible(true);
        assertEquals("Charlie", nameField.get(user), "Name field should be set via reflection");
    }

    @Test
    @DisplayName("Test setters")
    void testSetters() {
        User user = new User();

        user.setId(3L);
        user.setName("David");

        assertAll(
                () -> assertEquals(3L, user.getId(), "Setter should set ID"),
                () -> assertEquals("David", user.getName(), "Setter should set name")
        );
    }

    @Test
    @DisplayName("Test Lombok annotations")
    void testLombokAnnotations() {
        assertAll(
                "Verify all Lombok-generated methods exist",
                () -> assertDoesNotThrow(() -> User.class.getMethod("getId")),
                () -> assertDoesNotThrow(() -> User.class.getMethod("getName")),
                () -> assertDoesNotThrow(() -> User.class.getMethod("setId", Long.class)),
                () -> assertDoesNotThrow(() -> User.class.getMethod("setName", String.class))
        );
    }
    @Test
    @DisplayName("Verify User class file structure")
    void testUserClassStructure() {
        Constructor<?>[] constructors = User.class.getDeclaredConstructors();
        assertEquals(3, constructors.length, "Should have 3 constructors");

        // Verify no-args constructor
        assertDoesNotThrow(() -> {
            try {
                User.class.getConstructor();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        // Verify (Long, String) constructor
        assertDoesNotThrow(() -> User.class.getConstructor(Long.class, String.class));

        // Verify (String) constructor
        assertDoesNotThrow(() -> User.class.getConstructor(String.class));
    }
}