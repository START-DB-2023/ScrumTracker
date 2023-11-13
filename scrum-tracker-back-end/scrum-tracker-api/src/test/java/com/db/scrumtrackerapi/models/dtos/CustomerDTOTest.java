package com.db.scrumtrackerapi.models.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.db.scrumtrackerapi.models.enums.Role;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@SpringBootTest
public class CustomerDTOTest {
    
    @Autowired
    private Validator validator;

    @Test
    @DisplayName("When Email is Valid Assert is Valid")
    public void testValidEmail() {
        CustomerDTO customerDTO = new CustomerDTO("joao@email.com","Joao","Ninguem", "letmein123", Role.ADMIN);

        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(true, violations.isEmpty());
    }

    @Test
    @DisplayName("When Email is Invalid Assert is Invalid.")
    public void testInvalidEmail() {
        CustomerDTO customerDTO = new CustomerDTO("Email Invalido","Joao","Ninguem", "letmein123", Role.ADMIN);

        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(false, violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    @DisplayName("When Name is valid Assert is Valid")
    public void testValidName() {
        CustomerDTO customerDTO = new CustomerDTO("joao@email.com","Joao","Ninguem", "letmein123", Role.ADMIN);

        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(true, violations.isEmpty());
    }

    @Test
    @DisplayName("when Name is Invalid Assert is Invalid")
    public void testInvalidName() {
        CustomerDTO customerDTO = new CustomerDTO("joao@email.com"," ","Ninguem", "letmein123", Role.ADMIN);

        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(false, violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    @DisplayName("When Lastname is Valid Assert is Valid")
    public void testValidLastName(){
        CustomerDTO customerDTO = new CustomerDTO("joao@email.com", "Joao", "Ninguem", "letmein123", Role.ADMIN);
        
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(true, violations.isEmpty());
    }

    @Test
    @DisplayName("When Lastname is Invalid Assert is Invalid")
    public void testInvalidLastName(){
        CustomerDTO customerDTO = new CustomerDTO("joao@email.com", "Joao", " ", "letmein123", Role.ADMIN);
        
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(false, violations.isEmpty());
    }

    @Test
    @DisplayName("When Password is Valid Assert is Valid.")
    public void testValidPassword(){
        CustomerDTO customerDTO = new CustomerDTO("joao@email.com","Joao", "Ninguem","letmein123",Role.ADMIN);
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(true,violations.isEmpty());
    }

    @Test
    @DisplayName("When Password Invalid Assert is Invalid.")
    public void testInvalidPassword(){
        CustomerDTO customerDTO = new CustomerDTO("joao@email.com","Joao","Ninguem"," ",Role.ADMIN);
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(false,violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    @DisplayName("When Password Null Assert is Invalid.")
    public void testNullPassword(){
        CustomerDTO customerDTO = new CustomerDTO("joao@email.com","Joao","Ninguem",null,Role.ADMIN);
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(false,violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    @DisplayName("When Role is Valid Assert is Valid.")
    public void testValidRole() {
        CustomerDTO customerDTO = new CustomerDTO("joao@email.com","Joao","Ninguem", "letmein123", Role.ADMIN);
        
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(true, violations.isEmpty());
    }
    
    @Test
    @DisplayName("When Role Invalid Assert is Invalid")
    public void testInvalidRole() {
        CustomerDTO customerDTO = new CustomerDTO("joao@email.com","Joao","Ninguem","letmein123", null);
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(false, violations.isEmpty());
    }

}
