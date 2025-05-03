package com.example.demo;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetAllUsers() {
        List<User> users = Arrays.asList(new User(1L, "Alice"), new User(2L, "Bob"));
        Mockito.when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();
        Assertions.assertEquals(2, result.size());
    }

    @Test
    void testCreateUser() {
        User user = new User( "Charlie");
        User savedUser = new User(1L, "Charlie");
        Mockito.when(userRepository.save(user)).thenReturn(savedUser);

        User result = userService.addUser(user.getName());
        Assertions.assertEquals("Charlie", result.getName());
        Assertions.assertNotNull(result.getId());
    }
}
