package devsu.microservices.userManagement.infraestructure.client.validation.unique;

import devsu.microservices.userManagement.infraestructure.config.db.repository.ClientRepository;
import devsu.microservices.userManagement.infraestructure.config.db.schema.ClientSchema;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UniqueIdentificationValidator implements ConstraintValidator<UniqueIdentification, String> {
    @Autowired
    private ClientRepository repository;

    @Override
    public boolean isValid(String identification, ConstraintValidatorContext context) {
        if (repository != null) {
            Optional<ClientSchema> customer = repository.findByIdentificacion(identification);
            return customer.isEmpty();
        }

        return true;
    }
}
