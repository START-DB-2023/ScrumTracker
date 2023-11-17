package com.db.scrumtrackerapi.model;
import java.util.Objects;

public class TokenMessage {
    private String Token;
    private String name;
    private String lastName;

    protected TokenMessage() {
    }

    public TokenMessage(String Token, String name, String lastName) {
        this.Token = Token;
        this.name = name;
        this.lastName = lastName;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TokenMessage)) {
            return false;
        }
        TokenMessage tokenMessage = (TokenMessage) o;
        return Objects.equals(Token, tokenMessage.Token) && Objects.equals(name, tokenMessage.name) && Objects.equals(lastName, tokenMessage.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Token, name, lastName);
    }

    @Override
    public String toString() {
        return "{" +
            " Token='" + getToken() + "'" +
            ", name='" + getName() + "'" +
            ", lastName='" + getLastName() + "'" +
            "}";
    }
    
}
