package devsu.microservices.userManagement.infraestructure.config.db.repository;

import devsu.microservices.userManagement.infraestructure.config.db.schema.PersonSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonSchema, UUID> {
}
