package devsu.microservices.userManagement.infraestructure.client.dto;

import devsu.microservices.userManagement.infraestructure.client.validation.formats.Gender;
import devsu.microservices.userManagement.infraestructure.client.validation.formats.Identification;
import devsu.microservices.userManagement.infraestructure.client.validation.formats.PhoneNumber;
import devsu.microservices.userManagement.infraestructure.client.validation.unique.UniqueIdentification;
import devsu.microservices.userManagement.usecase.client.dto.IClientRegistrationData;
import jakarta.validation.constraints.NotBlank;

public record ClientRegistrationData(
        @NotBlank
        String nombre,
        @Gender(message = "{Gender.client}")
        @NotBlank
        String genero,
        @NotBlank
        int edad,
        @UniqueIdentification(message = "{Unique.client.identificacion}")
        @NotBlank
        @Identification(message = "{Size.client.identificacion}")
        String identificacion,
        @NotBlank
        String direccion,
        @NotBlank
        @PhoneNumber(message = "{Size.client.telefono}")
        String telefono,
        @NotBlank
        String contrasena,
        @NotBlank
        Boolean estado
)

        implements IClientRegistrationData {
}