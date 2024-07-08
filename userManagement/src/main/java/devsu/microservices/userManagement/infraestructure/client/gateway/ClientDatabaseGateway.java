package devsu.microservices.userManagement.infraestructure.client.gateway;

import devsu.microservices.userManagement.entity.client.gateway.ClientGateway;
import devsu.microservices.userManagement.entity.client.model.Client;
import devsu.microservices.userManagement.infraestructure.config.db.repository.ClientRepository;
import devsu.microservices.userManagement.infraestructure.config.db.schema.ClientSchema;

import java.util.List;
import java.util.Optional;

public class ClientDatabaseGateway implements ClientGateway {
    private final ClientRepository clientRepository;

    public ClientDatabaseGateway(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public Client createClient(Client client) {
        return this.clientRepository.save(new ClientSchema(client)).toClient();

    }

    @Override
    public Client updateClient(Client client) {
        return null;
    }

    @Override
    public Optional<Client> getClientById(String clientId) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> getClientByIdentification(String identificationNumber) {
        return Optional.empty();
    }

    @Override
    public List<Client> getAllClients() {
        return List.of();
    }

    @Override
    public void deleteClient(String clientId) {

    }
}
