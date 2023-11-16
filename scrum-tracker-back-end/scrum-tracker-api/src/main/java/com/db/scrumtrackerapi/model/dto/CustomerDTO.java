package com.db.scrumtrackerapi.model.dto;

import org.springframework.security.crypto.password.PasswordEncoder;
import com.db.scrumtrackerapi.model.Customer;
import com.db.scrumtrackerapi.model.enums.Role;
import com.db.scrumtrackerapi.security.password.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Data Transfer Object (DTO) representing customer information for registration.
 * It includes fields such as name, lastName, email, password, and role.
 */
public class CustomerDTO {

    /**
     * The name of the customer.
     */
    @NotBlank(message = "Blank Field.")
    private String name;

    /**
     * The last name of the customer.
     */
    @NotBlank(message = "Blank Field.")
    private String lastName;

    /**
     * The email address of the customer.
     */
    @Email(message = "Invalid Email.")
    @NotBlank(message = "Blank Field.")
    private String email;

    /**
     * The password of the customer.
     */
    @NotBlank(message = "Blank Field.")
    @ValidPassword
    private String password;
    
    /**
     * The role of the customer, which can be ADMIN, SM, PO or DEV.
     */
    @NotNull(message = "Blank Field.")
    private Role role;

    /**
     * Converts the DTO object to a Customer entity.
     *
     * @param passwordEncoder Encoder for encoding the password.
     * @return A Customer entity created from the DTO.
     */
    public Customer toCustomer(PasswordEncoder passwordEncoder){
        Customer customer = new Customer(
            this.name, 
            this.lastName,
            this.email, 
            passwordEncoder.encode(this.password),
            this.role);

        return customer;
    }

    /**
     * Constructs a CustomerDTO with the provided values.
     *
     * @param name     The name of the customer.
     * @param lastName The last name of the customer.
     * @param email    The email address of the customer.
     * @param password The password of the customer.
     * @param role     The role of the customer.
     */
    public CustomerDTO(String name, String lastName, String email, String password, Role role) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    //public
    /**
     * Default constructor for CustomerDTO (protected to prevent public instantiation).
     */
    protected CustomerDTO() {
    }

    /**
     * Gets the name of the customer.
     *
     * @return The name of the customer.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the last name of the customer.
     *
     * @return The last name of the customer.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the last name of the customer.
     *
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email address of the customer.
     *
     * @return The email address of the customer.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email address of the customer.
     *
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password of the customer.
     *
     * @return The password of the customer.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the password of the customer.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the role of the customer.
     *
     * @return The role of the customer.
     */
    public Role getRole() {
        return this.role;
    }

    /**
     * Sets the role of the customer.
     *
     * @param role The role to set.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The reference object with which to compare.
     * @return True if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CustomerDTO)) {
            return false;
        }
        CustomerDTO customerDTO = (CustomerDTO) o;
        return Objects.equals(name, customerDTO.name) && Objects.equals(lastName, customerDTO.lastName) && Objects.equals(email, customerDTO.email) && Objects.equals(password, customerDTO.password) && Objects.equals(role, customerDTO.role);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, email, password, role);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            ", role='" + getRole() + "'" +
            "}";
    }
    
}
