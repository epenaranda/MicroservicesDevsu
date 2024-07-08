package devsu.microservices.userManagement.usecase.client;

import devsu.microservices.userManagement.entity.client.exception.ClientNotFoundException;
import devsu.microservices.userManagement.entity.client.gateway.ClientGateway;
import devsu.microservices.userManagement.entity.client.model.Client;

import java.util.List;

public class GetListClientUseCase {

    private final ClientGateway clientGateway;

    public GetListClientUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    public List<Client> execute() throws ClientNotFoundException {
        List<Client> clients = this.clientGateway
                .getAllClients();
        if (clients == null || clients.isEmpty()) {
            throw new ClientNotFoundException("No clients found.");
        }
        return clients;

    }

}
