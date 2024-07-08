package devsu.microservices.userManagement.infraestructure.client.validation.unique;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueIdentificationValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueIdentification {
    String message() default "Identification is already registered";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
