package devsu.microservices.userManagement.usecase.client;

import devsu.microservices.userManagement.entity.client.exception.ClientNotFoundException;
import devsu.microservices.userManagement.entity.client.gateway.ClientGateway;
import devsu.microservices.userManagement.entity.client.model.Client;
import devsu.microservices.userManagement.usecase.client.dto.IClientUpdateData;

public class UpdateClientUseCase {
    private final ClientGateway clientGateway;

    public UpdateClientUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
    }

    public Client execute(String id, IClientUpdateData data) throws ClientNotFoundException {
        Client client = this.clientGateway.getClientById(id)
                .orElseThrow(ClientNotFoundException::new);

        if (data.nombre() != null && !data.nombre().isBlank()) {
            client.setNombre(data.nombre());
        }
        if (data.direccion() != null && !data.direccion().isBlank()) {
            client.setDireccion(data.direccion());
        }
        if (data.telefono() != null && !data.telefono().isBlank()) {
            client.setTelefono(data.telefono());
        }
        if (data.estado() != null && !data.estado().isBlank()) {
            client.setEstado(data.estado());
        }

        return this.clientGateway.updateClient(client);
    }
}
