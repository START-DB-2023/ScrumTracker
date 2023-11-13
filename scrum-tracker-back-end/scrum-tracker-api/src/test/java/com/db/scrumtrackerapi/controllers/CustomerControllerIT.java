package com.db.scrumtrackerapi.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.db.scrumtrackerapi.models.dtos.CustomerDTO;
import com.db.scrumtrackerapi.models.enums.Role;
import com.db.scrumtrackerapi.models.view.CustomerView;
import com.db.scrumtrackerapi.services.CustomerDTOSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class CustomerControllerIT {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate;
    private HttpHeaders headers;
    private CustomerDTOSerializer customerDTOSerializer;
    SimpleModule module;
    ObjectMapper objectMapper;

    @BeforeAll
    public void setUp() {
        restTemplate = new TestRestTemplate();

        customerDTOSerializer= new CustomerDTOSerializer();
        module = new SimpleModule().addSerializer(CustomerDTO.class, customerDTOSerializer);
        objectMapper = new ObjectMapper().registerModule(module);
    }

    @Test
    void testGetCustomerByEmail() throws JsonProcessingException {
        headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        String email = "joao@email.com";
        CustomerView expectedResponse = new CustomerView("Joao", "Ninguem", email, "ADMIN");

        CustomerDTO requestBody = new CustomerDTO("joao@email.com", "Joao", "Ninguem", "letmein123", Role.ADMIN);
        String requestBodyJson = objectMapper.writeValueAsString(requestBody);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBodyJson, headers);

        restTemplate.postForEntity("http://localhost:" + port + "/customer"+"?email="+email, requestEntity, CustomerView.class);
        
        ResponseEntity<CustomerView> response = restTemplate.getForEntity("http://localhost:" + port + "/customer"+"?email="+email, CustomerView.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

}
