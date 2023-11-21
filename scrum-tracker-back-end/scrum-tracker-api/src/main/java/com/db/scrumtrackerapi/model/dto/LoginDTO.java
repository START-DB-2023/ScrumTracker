package com.db.scrumtrackerapi.model.dto;
import java.util.Objects;

/**
 * Data Transfer Object (DTO) representing login information.
 * Contains an email and password for authentication purposes.
 */
public class LoginDTO {

    /**
     * The email associated with the login.
     */
    private String email;

    /**
     * The password associated with the login.
     */
    private String password;

    /**
     * Protected empty constructor for use by persistence frameworks.
     */
    protected LoginDTO() {
    }

    /**
     * Creates a new LoginDTO with the specified email and password.
     *
     * @param email    The email for the login.
     * @param password The password for the login.
     */
    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Gets the email associated with the login.
     *
     * @return The email for the login.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email associated with the login.
     *
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password associated with the login.
     *
     * @return The password for the login.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the password associated with the login.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LoginDTO)) {
            return false;
        }
        LoginDTO loginDTO = (LoginDTO) o;
        return Objects.equals(email, loginDTO.email) && Objects.equals(password, loginDTO.password);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(email, password);
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
            ", password='" + getPassword() + "'" +
            "}";
    }
    
}

