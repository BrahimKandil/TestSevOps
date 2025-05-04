package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetAllUsers() {
        List<User> users = List.of(
                new User(1L, "Alice"),
                new User(2L, "Bob")
        );
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();
        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getName());
    }

    @Test
    void testCreateUser() {
        User savedUser = new User(1L, "Charlie");
        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        User result = userService.addUser("Charlie");
        assertEquals("Charlie", result.getName());
        assertEquals(1L, result.getId());
    }
    @Test
    void testCreateUserJson() {
        User savedUser = new User(1L, "Charlie");
        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        User result = userService.addUser(new User("Charlie"));
        assertEquals("Charlie", result.getName());
        assertEquals(1L, result.getId());
    }
}