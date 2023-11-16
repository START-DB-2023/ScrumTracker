package com.db.scrumtrackerapi.model.view;

import java.util.Objects;

/**
 * View class representing customer information, typically used for responses.
 */
public class CustomerView {
    /**
     * The name of the customer.
     */
    private String name;
    
     /**
     * The last name of the customer.
     */
    private String lastName;
    
    /**
     * The email address of the customer.
     */
    private String email;
    
    /**
     * The role of the customer, which can be ADMIN, SM, PO or DEV.
     */
    private String role;

    /**
     * Constructs a CustomerView with the provided values.
     *
     * @param name     The name of the customer.
     * @param lastName The last name of the customer.
     * @param email    The email address of the customer.
     * @param role     The role of the customer.
     */
    public CustomerView(String name, String lastName, String email, String role) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    /**
     * Default constructor for CustomerView (protected to prevent public instantiation).
     */
    protected CustomerView() {
    
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
     * Gets the role of the customer.
     *
     * @return The role of the customer.
     */
    public String getRole() {
        return this.role;
    }

    /**
     * Sets the role of the customer.
     *
     * @param role The role to set.
     */
    public void setRole(String role) {
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
        if (!(o instanceof CustomerView)) {
            return false;
        }
        CustomerView customerView = (CustomerView) o;
        return Objects.equals(name, customerView.name) && Objects.equals(lastName, customerView.lastName) && Objects.equals(email, customerView.email) && Objects.equals(role, customerView.role);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, email, role);
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
            ", role='" + getRole() + "'" +
            "}";
    }
    
}
