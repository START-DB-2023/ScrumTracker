package com.db.scrumtrackerapi.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.HttpHeaders;
import org.springframework.security.test.context.support.WithMockUser;

import com.db.scrumtrackerapi.controller.CustomerController;
import com.db.scrumtrackerapi.model.view.CustomerView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CustomerControllerTest {
    
    private MockMvc mockMvc;

    @Autowired
    private CustomerController customerController;

    private ObjectMapper objectMapper = new ObjectMapper();

    private HttpHeaders headers;
    
    private CustomerView responseBody;

    private String responseBodyJson;

    @BeforeAll
    public void setUp() throws JsonProcessingException {
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

        headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        
        responseBody = new CustomerView( "Joao", "Ninguem", "joao@email.com", "ADMIN");
        responseBodyJson = objectMapper.writeValueAsString(responseBody);
    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void testGetCustomerByEmail() throws Exception{
        String email = "joao@email.com";
        mockMvc.perform(get("/customer?email="+email))
        .andExpect(status().isOk())
        .andExpect(content().json(responseBodyJson));
    }

}
