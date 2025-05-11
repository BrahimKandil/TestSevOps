package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testGetAllUsers() {
        userRepository.save(new User(null, "Alice"));
        userRepository.save(new User(null, "Bob"));

        List<User> result = userService.getAllUsers();
        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getName());
    }

    @Test
    void testCreateUser() {
        User result = userService.createUser("Charlie");

        assertNotNull(result.getId());
        assertEquals("Charlie", result.getName());
    }

    @Test
    void testCreateUserJson() {
        User user = new User();
        user.setName("Charlie");

        User result = userService.createUserJson(user);
        assertNotNull(result.getId());
        assertEquals("Charlie", result.getName());
    }

    @Test
    void testNameOnlyConstructor() {
        User user = new User();
        user.setName("Charlie");
        assertEquals("Charlie", user.getName());
    }
}
