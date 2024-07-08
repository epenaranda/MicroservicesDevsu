package devsu.microservices.userManagement.usecase.client;

import devsu.microservices.userManagement.entity.client.gateway.ClientGateway;
import devsu.microservices.userManagement.entity.client.model.Client;
import devsu.microservices.userManagement.entity.person.model.Gender;
import devsu.microservices.userManagement.entity.person.model.Person;
import devsu.microservices.userManagement.usecase.client.dto.IClientRegistrationData;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

public class CreateClientUseCase {
    private final ClientGateway clientGateway;
    private final BCryptPasswordEncoder passwordEncoder;

    public CreateClientUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
        this.passwordEncoder = new BCryptPasswordEncoder();

    }

    public Client execute(IClientRegistrationData data) {
        Person person = new Client();

        UUID id = person.getId();

        String encodedPassword = passwordEncoder.encode(data.contrasena());


        Client client = new Client(id, data.nombre(), Gender.valueOf(data.genero()), data.edad(),
                data.identificacion(), data.direccion(), data.telefono(), encodedPassword,
                data.estado().toString());


        return this.clientGateway.createClient(client);
    }
}
