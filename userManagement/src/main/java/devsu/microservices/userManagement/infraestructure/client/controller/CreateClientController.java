package devsu.microservices.userManagement.infraestructure.client.controller;

import devsu.microservices.userManagement.entity.client.model.Client;
import devsu.microservices.userManagement.infraestructure.client.dto.ClientPublicData;
import devsu.microservices.userManagement.infraestructure.client.dto.ClientRegistrationData;
import devsu.microservices.userManagement.infraestructure.responses.ApiResponse;
import devsu.microservices.userManagement.infraestructure.responses.DataWrapper;
import devsu.microservices.userManagement.usecase.client.CreateClientUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreateClientController {
    private final CreateClientUseCase createClientUseCase;

    public CreateClientController(CreateClientUseCase createClientUseCase) {
        this.createClientUseCase = createClientUseCase;
    }

    @PostMapping("/api/v1/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<ClientPublicData> createCustomer(@Valid @RequestBody ClientRegistrationData data) {
        Client client = createClientUseCase.execute(data);
        ClientPublicData clientPublicData = new ClientPublicData(client);
        DataWrapper<ClientPublicData> dataWrapper = new DataWrapper<>("user", 1, clientPublicData);
        return new ApiResponse<>(List.of(dataWrapper));
    }
}

