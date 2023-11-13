package com.db.scrumtrackerapi.models.dtos;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.db.scrumtrackerapi.models.Customer;
import com.db.scrumtrackerapi.models.enums.Role;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CustomerDTO {

    @Email(message = "E-mail Inválido.")
    @NotBlank(message = "Blank Field.")
    private String email;

    @NotBlank(message = "Blank Field.")
    private String name;

    @NotBlank(message = "Blank Field.")
    private String lastName;

    @NotBlank(message = "Blank Field.")
    private String password;
    
    @NotNull(message = "Blank Field.")
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    private Role role;

    public Customer toCustomer(PasswordEncoder passwordEncoder){
        Customer customer = new Customer(
            this.email, 
            this.name, 
            this.lastName,
            passwordEncoder.encode(this.password),
            this.role);

        return customer;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public CustomerDTO(String email, String name, String lastName, String password, Role role) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
    }


    public CustomerDTO() {
    }


}
