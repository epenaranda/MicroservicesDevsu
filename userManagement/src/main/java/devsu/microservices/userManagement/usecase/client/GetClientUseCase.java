package devsu.microservices.userManagement.usecase.client;

import devsu.microservices.userManagement.entity.client.exception.ClientNotFoundException;
import devsu.microservices.userManagement.entity.client.gateway.ClientGateway;
import devsu.microservices.userManagement.entity.client.model.Client;

public class GetClientUseCase {
    private final ClientGateway clientGateway;

    public GetClientUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    public Client execute(String id) throws ClientNotFoundException {
        return this.clientGateway
                .getClientById(id)
                .orElseThrow(ClientNotFoundException::new);
    }
}
