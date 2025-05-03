package com.example.demo;

import com.example.demo.controller.UserController;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(UserController.class)  // Focuses on the UserController for testing.
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;  // Used for simulating HTTP requests and responses

    private UserService userService;  // Mocks the UserService to be injected into UserController

    @Test
    void testGetAllUsers() throws Exception {
        // Setup the mock service behavior
        List<User> users = List.of(new User(1L, "Alice"));
        Mockito.when(userService.getAllUsers()).thenReturn(users);

        // Perform a mock HTTP GET request and verify the results
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())  // Expect HTTP 200 OK
                .andExpect(jsonPath("$[0].name").value("Alice"));  // Verify that Alice's name is returned
    }
}
