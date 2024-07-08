package devsu.microservices.userManagement.infraestructure.client.controller;


import devsu.microservices.userManagement.entity.client.exception.ClientNotFoundException;
import devsu.microservices.userManagement.infraestructure.client.dto.ClientPublicData;
import devsu.microservices.userManagement.usecase.client.DeleteClientUseCase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clients")
public class DeleteClientController {
    private final DeleteClientUseCase deleteClientUseCase;


    public DeleteClientController(DeleteClientUseCase deleteClientUseCase) {
        this.deleteClientUseCase = deleteClientUseCase;
    }

    @DeleteMapping("/{id}")
    public ClientPublicData deleteClient(@PathVariable String id) throws ClientNotFoundException {
        return new ClientPublicData(deleteClientUseCase.execute(id));
    }
}
