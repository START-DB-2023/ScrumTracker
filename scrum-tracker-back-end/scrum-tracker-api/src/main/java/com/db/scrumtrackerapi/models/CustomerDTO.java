package com.db.scrumtrackerapi.models;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.db.scrumtrackerapi.models.enums.Role;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerDTO {
    private String email;
    private String name;
    private String lastName;
    private String password;
    
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

}
