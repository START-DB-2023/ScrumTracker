package com.db.scrumtrackerapi.model;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Represents an error message containing details about an exception or error in the system.
 */
public class ErrorMessage {
    
    /**
     * A brief description of the error.
     */
    private String description;

    /**
     * The HTTP status code associated with the error.
     */
    private int status;

    /**
     * The detailed exception message providing more information about the error.
     */
    private String exceptionMessage;
    
    /**
     * The timestamp when the error occurred.
     */
    private LocalDateTime timestamp;
    

    /**
     * Constructs an ErrorMessage object with the specified parameters.
     *
     * @param description       A brief description of the error.
     * @param status            The HTTP status code associated with the error.
     * @param exceptionMessage  The detailed exception message providing more information about the error.
     */
    public ErrorMessage(String description, int status, String exceptionMessage) {
        this.description = description;
        this.status = status;
        this.exceptionMessage = exceptionMessage;
        this.timestamp = LocalDateTime.now();
    }

    /**
     * Gets the description of the error.
     *
     * @return A brief description of the error.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of the error.
     *
     * @param description A brief description of the error.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the HTTP status code associated with the error.
     *
     * @return The HTTP status code.
     */
    public int getStatus() {
        return this.status;
    }

    /**
     * Sets the HTTP status code associated with the error.
     *
     * @param status The HTTP status code.
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Gets the detailed exception message providing more information about the error.
     *
     * @return The exception message.
     */
    public String getExceptionMessage() {
        return this.exceptionMessage;
    }

    /**
     * Sets the detailed exception message providing more information about the error.
     *
     * @param exceptionMessage The exception message.
     */
    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    /**
     * Gets the timestamp when the error occurred.
     *
     * @return The timestamp.
     */
    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    /**
     * Sets the timestamp when the error occurred.
     *
     * @param date The timestamp.
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public void setTimestamp(LocalDateTime date) {
        this.timestamp = date;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The object to compare.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ErrorMessage)) {
            return false;
        }
        ErrorMessage errorMessage = (ErrorMessage) o;
        return Objects.equals(description, errorMessage.description) && status == errorMessage.status && Objects.equals(exceptionMessage, errorMessage.exceptionMessage) && Objects.equals(timestamp, errorMessage.timestamp);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(description, status, exceptionMessage, timestamp);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation.
     */
    @Override
    public String toString() {
        return "{" +
            " description='" + getDescription() + "'" +
            ", status='" + getStatus() + "'" +
            ", exceptionMessage='" + getExceptionMessage() + "'" +
            ", date='" + getTimestamp() + "'" +
            "}";
    }

}
