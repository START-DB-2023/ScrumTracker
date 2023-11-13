package com.db.scrumtrackerapi.models;

import java.util.Objects;

import com.db.scrumtrackerapi.models.enums.Role;
import com.db.scrumtrackerapi.models.view.CustomerView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
    
    @Column(name = "email", nullable = false, unique = true, columnDefinition = "VARCHAR(255)")
    private String email;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(255)")
    private String name;

    @Column(name = "lastName", nullable = false, columnDefinition = "VARCHAR(255)")
    private String lastName;

    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR(255)")
    private String password;

    @Column(name = "role", nullable = false)
    private Role role;
    
    public CustomerView toView(){
       return new CustomerView(this.name, this.lastName, this.email, this.role.name());
    }

    protected Customer() {
    }

    public Customer(String email, String name, String lastName, String password, Role role) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
    }

    public Long getId(){
        return super.getId();
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(email, customer.email) && Objects.equals(name, customer.name) && Objects.equals(lastName, customer.lastName) && Objects.equals(password, customer.password) && Objects.equals(role, customer.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, lastName, password, role);
    }

    @Override
    public String toString() {
        return "{" +
            " email='" + getEmail() + "'" +
            ", name='" + getName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", password='" + getPassword() + "'" +
            ", role='" + getRole() + "'" +
            "}";
    }

}
