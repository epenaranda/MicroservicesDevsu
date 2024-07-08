package devsu.microservices.userManagement.usecase.client.dto;

public interface IClientUpdatePasswordData {
    String identification();

    String oldPassword();

    String newPassword();
}
