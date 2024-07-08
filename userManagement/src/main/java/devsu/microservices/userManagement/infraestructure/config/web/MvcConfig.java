package devsu.microservices.userManagement.infraestructure.config.web;


import devsu.microservices.userManagement.entity.client.gateway.ClientGateway;
import devsu.microservices.userManagement.infraestructure.client.gateway.ClientDatabaseGateway;
import devsu.microservices.userManagement.infraestructure.config.db.repository.ClientRepository;
import devsu.microservices.userManagement.usecase.client.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import java.util.ResourceBundle;

@Configuration
public class MvcConfig {

    @Bean
    public ResourceBundle messageBundle() {
        return ResourceBundle.getBundle("ValidationMessages");
    }

    @Bean
    public LocaleResolver sessionLocaleResolver() {
        return new AcceptHeaderResolver();
    }

    @Bean
    public CreateClientUseCase createClientUseCase(ClientRepository clientRepository) {
        ClientGateway clientGateway = new ClientDatabaseGateway(clientRepository);
        return new CreateClientUseCase(clientGateway);
    }

    @Bean
    public GetClientUseCase getClientUseCase(ClientRepository clientRepository) {
        ClientGateway clientGateway = new ClientDatabaseGateway(clientRepository);
        return new GetClientUseCase(clientGateway);
    }

    @Bean
    public GetListClientUseCase getListClientUseCase(ClientRepository clientRepository) {
        ClientGateway clientGateway = new ClientDatabaseGateway(clientRepository);
        return new GetListClientUseCase(clientGateway);
    }

    @Bean
    public UpdateClientUseCase updateClientUseCase(ClientRepository clientRepository) {
        ClientGateway clientGateway = new ClientDatabaseGateway(clientRepository);
        return new UpdateClientUseCase(clientGateway);
    }

    @Bean
    public UpdatePasswordClientUseCase updatePasswordClientUseCase(ClientRepository clientRepository) {
        ClientGateway clientGateway = new ClientDatabaseGateway(clientRepository);
        return new UpdatePasswordClientUseCase(clientGateway);
    }

    @Bean
    public DeleteClientUseCase deleteClientUseCase(ClientRepository clientRepository) {
        ClientGateway clientGateway = new ClientDatabaseGateway(clientRepository);
        return new DeleteClientUseCase(clientGateway);
    }
}