package com.db.scrumtrackerapi.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.db.scrumtrackerapi.controller.RegisterCustomerController;
import com.db.scrumtrackerapi.models.Customer;
import com.db.scrumtrackerapi.models.dtos.CustomerDTO;
import com.db.scrumtrackerapi.models.enums.Role;
import com.db.scrumtrackerapi.models.view.CustomerView;
import com.db.scrumtrackerapi.services.CustomerDTOSerializer;
import com.db.scrumtrackerapi.services.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class RegisterControllerTest {
    
    @Autowired
    @InjectMocks
    private RegisterCustomerController registerCustomerController;

    @Mock
    private CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    private MockMvc mockMvc;
    private CustomerDTOSerializer customerDTOSerializer;
    private SimpleModule module;
    private ObjectMapper objectMapper;
    private HttpHeaders headers;

    @BeforeAll
    public void setUp() throws JsonProcessingException {

        customerDTOSerializer= new CustomerDTOSerializer();
        module = new SimpleModule().addSerializer(CustomerDTO.class, customerDTOSerializer);
        objectMapper = new ObjectMapper().registerModule(module);

        mockMvc = MockMvcBuilders.standaloneSetup(registerCustomerController).build();
    }

    @Test
    void testRegisterCustomer() throws Exception {
        headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        
        CustomerView responseBody = new CustomerView( "Joao", "Ninguem", "joao@email.com", "ADMIN");
        String responseBodyJson = objectMapper.writeValueAsString(responseBody);

        CustomerDTO requestBody = new CustomerDTO("joao@email.com", "Joao", "Ninguem", "letmein123", Role.ADMIN);
        String requestBodyJson = objectMapper.writeValueAsString(requestBody);

        Customer expectedCustomer = requestBody.toCustomer(passwordEncoder);
        
        when(customerService.save(any(Customer.class))).thenReturn(expectedCustomer);
       
        mockMvc.perform(post("/register").headers(headers).content(requestBodyJson))
        .andExpect(status().isCreated())
        .andExpect(content().json(responseBodyJson)).andReturn();

         verify(customerService).save(any(Customer.class));
    }

    @Test
    void testRegisterCustomerDataBase() throws Exception {
        headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        CustomerDTO requestBody = new CustomerDTO("joao@email.com", "Joao", "Ninguem", "letmein123", Role.ADMIN);
        String requestBodyJson = objectMapper.writeValueAsString(requestBody);

        when(customerService.save(any(Customer.class))).thenThrow(new SQLException("Error"));

        mockMvc.perform(post("/register").headers(headers).content(requestBodyJson))
        .andExpect(status().isInternalServerError())
        .andReturn();

        verify(customerService).save(any(Customer.class));
    }

}
