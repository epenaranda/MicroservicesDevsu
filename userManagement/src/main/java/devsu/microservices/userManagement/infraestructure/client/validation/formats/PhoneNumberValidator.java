package devsu.microservices.userManagement.infraestructure.client.validation.formats;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        if (phoneNumber == null || phoneNumber.isBlank())
            return true; // Ignoramos se o campo é nulo em requisições de atualização

        /*
         * ^ - Start of the string.
         * \( - An opening parenthesis.
         * [1-9]{2} - Two digits from 1 to 9. DDD (area code) cannot start with 0.
         * \) - A closing parenthesis.
         *   - A whitespace.
         * (?:[2-8]|9[1-9]) - The start of the number. Represents a choice between a digit from 2 to 8 ([2-8] part) and 9 followed by a digit from 1 to 9 (9[1-9] part). The | separates the choices to be made. The (?: ...) groups these choices. Landline numbers start with digits 2 to 8. Mobile numbers start with 9 and have a second digit from 1 to 9. The first digit will never be 0 or 1. Mobile numbers cannot start with 90 because that is the prefix for collect calls.
         * [0-9]{3} - The remaining three digits of the first half of the phone number, making a total of 4 or 5 digits in the first half.
         * \- - A hyphen.
         * [0-9]{4} - The second half of the phone number.
         * $ - End of the string.
         */

        return phoneNumber.matches("^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$");
    }
}
