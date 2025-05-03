package com.example.demo;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void getAllUsersReturnsUsers() {
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.findAll()).thenReturn(List.of(new User("Alice")));

        UserService service = new UserService(mockRepo);
        List<User> users = service.getAllUsers();

        assertEquals(1, users.size());
        assertEquals("Alice", users.get(0).getName());
    }
}
