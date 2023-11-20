package com.db.scrumtrackerapi.model.dto;
import java.util.Objects;

/**
 * Represents a message containing a token along with a name and last name.
 */
public class TokenMessageDTO {

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
     * Default constructor. Creates an instance of TokenMessage.
     */
    protected TokenMessageDTO() {
    }

    /**
     * Creates an instance of TokenMessage with the specified attributes.
     *
     * @param Token     The token in the message.
     * @param name      The name in the message.
     * @param lastName  The last name in the message.
     */
    public TokenMessageDTO(String Token, String name, String lastName) {
        this.Token = Token;
        this.name = name;
        this.lastName = lastName;
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
     * @param Token The token in the message.
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
     * @param name The name in the message.
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
     * @param lastName The last name in the message.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Checks whether two TokenMessage objects are equal.
     *
     * @param o The object to compare.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TokenMessageDTO)) {
            return false;
        }
        TokenMessageDTO tokenMessage = (TokenMessageDTO) o;
        return Objects.equals(Token, tokenMessage.Token) && Objects.equals(name, tokenMessage.name) && Objects.equals(lastName, tokenMessage.lastName);
    }

    /**
     * Generates a hash code for the TokenMessage object.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(Token, name, lastName);
    }

    /**
     * Returns a string representation of the TokenMessage object.
     *
     * @return A string representation.
     */
    @Override
    public String toString() {
        return "{" +
            " Token='" + getToken() + "'" +
            ", name='" + getName() + "'" +
            ", lastName='" + getLastName() + "'" +
            "}";
    }
}

