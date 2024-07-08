package devsu.microservices.userManagement.infraestructure.client.validation.formats;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = GenderValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Gender {
    String message() default "Input a valid gender.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}