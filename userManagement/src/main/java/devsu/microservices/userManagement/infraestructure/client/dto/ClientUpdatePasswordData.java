package devsu.microservices.userManagement.infraestructure.client.dto;

import devsu.microservices.userManagement.infraestructure.client.validation.formats.Identification;
import devsu.microservices.userManagement.usecase.client.dto.IClientUpdatePasswordData;
import jakarta.validation.constraints.NotBlank;

public record ClientUpdatePasswordData(
        @NotBlank
        @Identification(message = "{Identification.person.identification}")
        String identification,
        @NotBlank
        String oldPassword,
        @NotBlank
        String newPassword)
        implements IClientUpdatePasswordData {
}


