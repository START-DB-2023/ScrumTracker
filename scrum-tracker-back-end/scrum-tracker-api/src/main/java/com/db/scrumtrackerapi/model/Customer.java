package com.db.scrumtrackerapi.model;

import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.db.scrumtrackerapi.model.enums.Role;
import com.db.scrumtrackerapi.model.view.CustomerView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Represents a customer entity with various attributes such as name, email, password, and role.
 * 
 * <p> Extends the {@link BaseEntity} class, providing common fields like ID and creation/update timestamps.
 */
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
    /**
     * The name of the customer.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * The last name of the customer.
     */
    @Column(name = "lastName", nullable = false)
    private String lastName;

    /**
     * The email address of the customer.
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /**
     * The password of the customer.
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * The role of the customer, which can be ADMIN, SM, PO or DEV.
     */
    @Column(name = "role", nullable = false)
    private Role role;
    

    /**
     * Converte um objeto Customer em UserDetails.
     *
     * Este método cria um UserDetails a partir das informações do cliente, incluindo o nome de usuário,
     * a senha e as autorizações associadas ao papel do cliente.
     *
     * @param customer O objeto Customer a ser convertido em UserDetails.
     * @return Um objeto UserDetails criado a partir das informações do cliente.
     * @throws NullPointerException Se o objeto Customer fornecido for nulo.
     */
    public UserDetails toUserDetail() {
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(getRole().name()));
        return new User(getEmail(), getPassword(), authorities);
    }

    /**
     * Converts the customer entity to a view representation.
     *
     * @return A CustomerView object representing the customer.
     */
    public CustomerView toView(){
       return new CustomerView(
        this.name, 
        this.lastName, 
        this.email, 
        this.role.name());
    }

    /**
     * Constructs a Customer with the provided values.
     *
     * @param name     The name of the customer.
     * @param lastName The last name of the customer.
     * @param email    The email address of the customer.
     * @param password The password of the customer.
     * @param role     The role of the customer.
     */
    public Customer(String name, String lastName, String email, String password, Role role) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        super.setActive(true);
        super.setTimestamp();
    }

    /**
     * Default constructor for Customer (protected to prevent public instantiation).
     */
    protected Customer() {
    }

    /**
     * Gets the unique identifier of the customer.
     *
     * @return The unique identifier of the customer.
     */
    public Long getId(){
        return super.getId();
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
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(email, customer.email) && Objects.equals(name, customer.name) && Objects.equals(lastName, customer.lastName) && Objects.equals(password, customer.password) && Objects.equals(role, customer.role);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(email, name, lastName, password, role);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
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
