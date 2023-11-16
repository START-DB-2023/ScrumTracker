package com.db.scrumtrackerapi.models.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.db.scrumtrackerapi.model.dto.CustomerDTO;
import com.db.scrumtrackerapi.model.enums.Role;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@SpringBootTest
public class CustomerDTOTest {
    
    @Autowired
    private Validator validator;

    @Test
    @DisplayName("When Email is Valid Assert is Valid")
    public void testValidEmail() {
        CustomerDTO customerDTO = new CustomerDTO("Joao","Ninguem","joao@email.com", "l3tMe!nI23", Role.ADMIN);

        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(true, violations.isEmpty());
    }

    @Test
    @DisplayName("When Email is Invalid Assert is Invalid.")
    public void testInvalidEmail() {
        CustomerDTO customerDTO = new CustomerDTO("Joao","Ninguem", "Email Invalido", "l3tMe!nI23", Role.ADMIN);

        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(false, violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    @DisplayName("When Name is Valid Assert is Valid")
    public void testValidName() {
        CustomerDTO customerDTO = new CustomerDTO("Joao","Ninguem","joao@email.com", "l3tMe!nI23", Role.ADMIN);

        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(true, violations.isEmpty());
    }

    @Test
    @DisplayName("when Name is Blank Assert is Invalid")
    public void testBlankName() {
        CustomerDTO customerDTO = new CustomerDTO(" ","Ninguem","joao@email.com", "l3tMe!nI23", Role.ADMIN);

        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(false, violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    @DisplayName("When Lastname is Valid Assert is Valid")
    public void testValidLastName(){
        CustomerDTO customerDTO = new CustomerDTO( "Joao", "Ninguem", "joao@email.com", "l3tMe!nI23", Role.ADMIN);
        
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(true, violations.isEmpty());
    }

    @Test
    @DisplayName("When Lastname is Blank Assert is Invalid")
    public void testBlankLastName(){
        CustomerDTO customerDTO = new CustomerDTO( "Joao", " ","joao@email.com", "l3tMe!nI23", Role.ADMIN);
        
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(false, violations.isEmpty());
    }

    @Test
    @DisplayName("When Password is Valid Assert is Valid.")
    public void testValidPassword(){
        CustomerDTO customerDTO = new CustomerDTO("Joao", "Ninguem", "joao@email.com", "l3tMe!nI23",Role.ADMIN);
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(true,violations.isEmpty());
    }

    @Test
    @DisplayName("When Password is Blank Assert is Invalid.")
    public void testBlankPassword(){
        CustomerDTO customerDTO = new CustomerDTO("Joao","Ninguem", "joao@email.com"," ",Role.ADMIN);
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(false,violations.isEmpty());
        assertEquals(2, violations.size());
    }

    @Test
    @DisplayName("When Password is Lesser Then 8 Characters Assert is Invalid.")
    public void testSmallPassword(){
        CustomerDTO customerDTO = new CustomerDTO("Joao","Ninguem", "joao@email.com", "l3tMe!n",Role.ADMIN);
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(false,violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    @DisplayName("When Password has Alphabetical Order Characters Assert is Invalid.")
    public void testAlphaSequentialPassword(){
        CustomerDTO customerDTO = new CustomerDTO("Joao","Ninguem", "joao@email.com", "abcl3tMe!n",Role.ADMIN);
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(false,violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    @DisplayName("When Password has Numerical Order Characters Assert is Invalid.")
    public void testNumericalSequentialPassword(){
        CustomerDTO customerDTO = new CustomerDTO("Joao","Ninguem", "joao@email.com", "123l3tMe!n",Role.ADMIN);
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(false,violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    @DisplayName("When Password doesn't have digits Assert is Invalid.")
    public void testPasswordWithoutDigits(){
        CustomerDTO customerDTO = new CustomerDTO("Joao","Ninguem", "joao@email.com", "asfflfastMe!n",Role.ADMIN);
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(false,violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    @DisplayName("When Password hdoesn't have symbols Assert is Invalid.")
    public void testPasswordWithoutSymbols(){
        CustomerDTO customerDTO = new CustomerDTO("Joao","Ninguem", "joao@email.com", "asfflfastMe1n",Role.ADMIN);
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(false,violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    @DisplayName("When Role is Valid Assert is Valid.")
    public void testValidRole() {
        CustomerDTO customerDTO = new CustomerDTO("Joao","Ninguem", "joao@email.com", "l3tMe!nI23", Role.ADMIN);
        
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(true, violations.isEmpty());
    }
    
    @Test
    @DisplayName("When Role is Null Assert is Invalid")
    public void testInvalidRole() {
        CustomerDTO customerDTO = new CustomerDTO("Joao","Ninguem", "joao@email.com", "l3tMe!nI23", null);
        Set<ConstraintViolation<CustomerDTO>> violations = validator.validate(customerDTO);
        assertEquals(false, violations.isEmpty());
    }

}
