package devsu.microservices.userManagement.entity.client.gateway;

import devsu.microservices.userManagement.entity.client.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientGateway {
    Client createClient(Client client);

    Client updateClient(Client client);

    Optional<Client> getClientById(String clientId);

    Optional<Client> getClientByIdentification(String identificationNumber);

    List<Client> getAllClients();

    void deleteClient(String clientId);

}
