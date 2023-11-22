package com.db.scrumtrackerapi.security.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 * Custom annotation for validating password constraints using the {@link PasswordConstraintValidator}.
 */
@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {

    /**
     * Defines the default error message for validation failure.
     *
     * @return The default error message.
     */
    String message() default "Invalid Password";

    /**
     * Specifies the validation groups to which this constraint belongs.
     *
     * @return The validation groups.
     */
    Class<?>[] groups() default {};

    /**
     * Specifies the payload associated with the constraint.
     *
     * @return The payload.
     */
    Class<? extends Payload>[] payload() default {};
}
