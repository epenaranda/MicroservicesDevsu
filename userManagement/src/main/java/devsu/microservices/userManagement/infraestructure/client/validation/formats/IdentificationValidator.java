package devsu.microservices.userManagement.infraestructure.client.validation.formats;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdentificationValidator implements ConstraintValidator<Identification, String> {
    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if (cpf == null || cpf.isBlank())
            return true;

        /*
         * [0-9]{2}       Range of characters: 0 to 9, quantity: 2 characters;
         * [0-9]{3}       Range of characters: 0 to 9, quantity: 3 characters;
         * [0-9]{4}       Range of characters: 0 to 9, quantity: 4 characters;
         * [\.]?          A dot, optional. Escaped with \ because it's a special character;
         * [-]?           A hyphen, optional (if you add more characters, always start with -);
         * [\/]?          A slash, optional. Also escaped with \ for PCRE compatibility;
         * (group1)|(group2) If either group validates, the expression is valid.
         */

        return cpf.matches("([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})");
    }
}
