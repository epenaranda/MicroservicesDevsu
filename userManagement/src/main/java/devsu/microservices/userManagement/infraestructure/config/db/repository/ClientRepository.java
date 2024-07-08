package devsu.microservices.userManagement.infraestructure.config.db.repository;

import devsu.microservices.userManagement.infraestructure.config.db.schema.ClientSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientSchema, UUID> {
    Optional<ClientSchema> findByIdentificacion(String identification);
}
