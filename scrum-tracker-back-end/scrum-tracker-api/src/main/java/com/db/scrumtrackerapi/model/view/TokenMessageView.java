package com.db.scrumtrackerapi.model.view;
import java.util.Objects;

import com.db.scrumtrackerapi.model.enums.Role;

/**
 * Represents a message containing a token along with a name, last name, and role.
 */
public class TokenMessageView {

    /**
     * The token in the message.
     */
    private String Token;

    /**
     * The name in the message.
     */
    private String name;

    /**
     * The last name in the message.
     */
    private String lastName;

    /**
     * The role associated with the message.
     */
    private Role role;

    /**
     * Default constructor for creating an empty TokenMessageView.
     */
    public TokenMessageView() {
    }

    /**
     * Creates a new TokenMessageView with the specified token, name, last name, and role.
     *
     * @param Token    The token in the message.
     * @param name     The name in the message.
     * @param lastName The last name in the message.
     * @param role     The role associated with the message.
     */
    public TokenMessageView(String Token, String name, String lastName, Role role) {
        this.Token = Token;
        this.name = name;
        this.lastName = lastName;
        this.role = role;
    }

    /**
     * Gets the token in the message.
     *
     * @return The token in the message.
     */
    public String getToken() {
        return this.Token;
    }

    /**
     * Sets the token in the message.
     *
     * @param Token The token to set.
     */
    public void setToken(String Token) {
        this.Token = Token;
    }

    /**
     * Gets the name in the message.
     *
     * @return The name in the message.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name in the message.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the last name in the message.
     *
     * @return The last name in the message.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the last name in the message.
     *
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the role associated with the message.
     *
     * @return The role associated with the message.
     */
    public Role getRole() {
        return this.role;
    }

    /**
     * Sets the role associated with the message.
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
     * @return {@code true} if this object is the same as the obj argument, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TokenMessageView)) {
            return false;
        }
        TokenMessageView tokenMessageDTO = (TokenMessageView) o;
        return Objects.equals(Token, tokenMessageDTO.Token) && Objects.equals(name, tokenMessageDTO.name) && Objects.equals(lastName, tokenMessageDTO.lastName) && Objects.equals(role, tokenMessageDTO.role);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(Token, name, lastName, role);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "{" +
            " Token='" + getToken() + "'" +
            ", name='" + getName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", role='" + getRole() + "'" +
            "}";
    }
}

