package com.db.scrumtrackerapi.controllers;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.security.test.context.support.WithMockUser;

import com.db.scrumtrackerapi.controller.CustomerController;
import com.db.scrumtrackerapi.model.Customer;
import com.db.scrumtrackerapi.model.dto.CustomerDTO;
import com.db.scrumtrackerapi.model.enums.Role;
import com.db.scrumtrackerapi.model.view.CustomerView;
import com.db.scrumtrackerapi.model.view.ErrorMessageView;
import com.db.scrumtrackerapi.services.impl.CustomerService;
import com.db.scrumtrackerapi.util.CustomerDTOSerializer;
import com.db.scrumtrackerapi.util.ErrorMessageSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
    
    private MockMvc mockMvc;

    @Autowired
    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    private ObjectMapper objectMapper = new ObjectMapper();
    private CustomerView responseBody;
    private String responseBodyJson;

    @BeforeAll
    public void setUp() throws JsonProcessingException {

        CustomerDTOSerializer customerDTOSerializer= new CustomerDTOSerializer();
        ErrorMessageSerializer errorMessageSerializer = new ErrorMessageSerializer();
        SimpleModule customerDtoSerializerModule = new SimpleModule().addSerializer(CustomerDTO.class, customerDTOSerializer);
        SimpleModule errorMessageSerializerModule = new SimpleModule().addSerializer(ErrorMessageView.class, errorMessageSerializer);
        
        objectMapper = new ObjectMapper()
                            .registerModule(customerDtoSerializerModule)
                            .registerModule(errorMessageSerializerModule);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

        responseBody = new CustomerView( "Joao", "Ninguem", "joao@email.com", "ADMIN");
        responseBodyJson = objectMapper.writeValueAsString(responseBody);

    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void testGetCustomerByEmail() throws Exception{

        Customer customer = new Customer( "Joao", "Ninguem", "joao@email.com", "Pass@2023", Role.ADMIN);
        
        String email = "joao@email.com";
        
        when(customerService.findByEmail(eq(email))).thenReturn(Optional.of(customer));
        
        mockMvc.perform(get("/customer?email="+email))
        .andExpect(status().isOk())
        .andExpect(content().json(responseBodyJson));
    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void testGetCustomerThatDontExistsByEmail() throws Exception{
       
        String email = "joao@email.com";
        
        when(customerService.findByEmail(eq(email))).thenReturn(Optional.empty());
        
        mockMvc.perform(get("/customer?email="+email))
        .andExpect(status().isNotFound()).andReturn();
    }

}
