package devsu.microservices.userManagement.infraestructure.client.validation.formats;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IdentificationValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Identification {
    String message() default "Input a valid identification.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
