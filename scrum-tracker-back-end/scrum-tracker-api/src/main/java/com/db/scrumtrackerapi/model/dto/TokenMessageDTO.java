package com.db.scrumtrackerapi.model.dto;
import java.util.Objects;

import com.db.scrumtrackerapi.model.enums.Role;

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

    private Role role;

    public TokenMessageDTO() {
    }

    public TokenMessageDTO(String Token, String name, String lastName, Role role) {
        this.Token = Token;
        this.name = name;
        this.lastName = lastName;
        this.role = role;
    }

    public String getToken() {
        return this.Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
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
        if (!(o instanceof TokenMessageDTO)) {
            return false;
        }
        TokenMessageDTO tokenMessageDTO = (TokenMessageDTO) o;
        return Objects.equals(Token, tokenMessageDTO.Token) && Objects.equals(name, tokenMessageDTO.name) && Objects.equals(lastName, tokenMessageDTO.lastName) && Objects.equals(role, tokenMessageDTO.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Token, name, lastName, role);
    }

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

