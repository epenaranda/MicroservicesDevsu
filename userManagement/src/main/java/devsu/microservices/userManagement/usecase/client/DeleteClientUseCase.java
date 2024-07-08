package devsu.microservices.userManagement.usecase.client;

import devsu.microservices.userManagement.entity.client.exception.ClientNotFoundException;
import devsu.microservices.userManagement.entity.client.gateway.ClientGateway;
import devsu.microservices.userManagement.entity.client.model.Client;

public class DeleteClientUseCase {
    private final ClientGateway clientGateway;

    public DeleteClientUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    public Client execute(String id) throws ClientNotFoundException {
        Client client = clientGateway.getClientById(id)
                .orElseThrow(ClientNotFoundException::new);

        clientGateway.deleteClient(id);

        return client;
    }

}
