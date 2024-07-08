package devsu.microservices.userManagement.usecase.client;

import devsu.microservices.userManagement.entity.client.exception.ClientNotFoundException;
import devsu.microservices.userManagement.entity.client.exception.InvalidPasswordException;
import devsu.microservices.userManagement.entity.client.gateway.ClientGateway;
import devsu.microservices.userManagement.entity.client.model.Client;
import devsu.microservices.userManagement.usecase.client.dto.IClientUpdatePasswordData;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UpdatePasswordClientUseCase {
    private final ClientGateway clientGateway;
    private final BCryptPasswordEncoder passwordEncoder;

    public UpdatePasswordClientUseCase(ClientGateway clientGateway) {
        this.clientGateway = clientGateway;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Client execute(String id, IClientUpdatePasswordData data) throws ClientNotFoundException, InvalidPasswordException {
        Client client = this.clientGateway.getClientById(id)
                .orElseThrow(ClientNotFoundException::new);

        if (data.newPassword() == null || data.newPassword().isBlank()) {
            throw new InvalidPasswordException("New password cannot be null or blank");
        }
        if (data.identification() == null || data.identification().isBlank()) {
            throw new ClientNotFoundException();
        }

        if (!passwordEncoder.matches(data.oldPassword(), client.getContrasena())) {
            throw new InvalidPasswordException("Old password is incorrect");
        }

        String encodedNewPassword = passwordEncoder.encode(data.newPassword());
        client.setContrasena(encodedNewPassword);

        return this.clientGateway.updateClient(client);
    }
}
