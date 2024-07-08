package devsu.microservices.userManagement.infraestructure.client.validation.formats;

import devsu.microservices.userManagement.entity.person.model.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;


@Component
public class GenderValidator implements ConstraintValidator<devsu.microservices.userManagement.infraestructure.client.validation.formats.Gender, String> {

    @Override
    public boolean isValid(String sex, ConstraintValidatorContext context) {
        if (sex == null || sex.isBlank()) return true;

        try {
            return Gender.valueOf(sex.toUpperCase()) != null;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
