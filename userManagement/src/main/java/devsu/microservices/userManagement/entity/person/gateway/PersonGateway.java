package devsu.microservices.userManagement.entity.person.gateway;

import devsu.microservices.userManagement.entity.person.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonGateway {
    void create(Person person);

    void update(Person person);

    void delete(String id);

    Optional<Person> findById(String id);

    List<Person> findAll();
}
