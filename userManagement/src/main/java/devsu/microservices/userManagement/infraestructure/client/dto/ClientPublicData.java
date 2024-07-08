package devsu.microservices.userManagement.infraestructure.client.dto;

import devsu.microservices.userManagement.entity.client.model.Client;
import devsu.microservices.userManagement.usecase.client.dto.IClientPublicData;

public record ClientPublicData(
        String nombres,
        String telefono,
        String estado
) implements IClientPublicData {
    public ClientPublicData(Client client) {
        this(
                client.getNombre(),
                client.getTelefono(),
                client.getEstado()
        );
    }
}