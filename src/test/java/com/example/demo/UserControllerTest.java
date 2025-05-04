package com.example.demo;

import com.example.demo.controller.UserController;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    private MockMvc mockMvc;
    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testGetAllUsers() throws Exception {
        // Setup MockMvc to use our controller
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        // Mock service behavior
        List<User> users = List.of(new User(1L, "Alice"));
        when(userService.getAllUsers()).thenReturn(users);

        // Perform and verify request
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Alice"));
    }

    @Test
    void testCreateUserFromParam() throws Exception {
        User user = new User(1L, "Charlie");
        when(userService.createUser("Charlie")).thenReturn(user);

        mockMvc.perform(post("/users/param")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "Charlie"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Charlie"));
    }

    @Test
    void testCreateUser() throws Exception {
        // This is the user expected to be returned by the service
        User savedUser = new User(1L, "Charlie");

        // This is the user that will be passed into the service method
        User requestUser = new User(null, "Charlie");

        when(userService.createUserJson(requestUser)).thenReturn(savedUser);

        mockMvc.perform(post("/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Charlie\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Charlie"));
    }

}