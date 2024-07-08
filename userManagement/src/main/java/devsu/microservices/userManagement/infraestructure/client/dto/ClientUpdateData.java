package devsu.microservices.userManagement.infraestructure.client.dto;

import devsu.microservices.userManagement.infraestructure.client.validation.formats.PhoneNumber;
import devsu.microservices.userManagement.infraestructure.validation.formats.Name;
import devsu.microservices.userManagement.usecase.client.dto.IClientUpdateData;
import jakarta.validation.constraints.NotBlank;

public record ClientUpdateData(
        @Name(message = "{Name.client.nombre}")
        String nombre,

        @NotBlank
        String direccion,

        @PhoneNumber(message = "{Telefono.client.telefono}")
        String telefono,

        @NotBlank
        String estado)
        implements IClientUpdateData {
}

