package devsu.microservices.userManagement.usecase.client.dto;

public interface IClientRegistrationData {
    String nombre();

    String genero();

    int edad();

    String identificacion();

    String direccion();

    String telefono();

    String contrasena();

    Boolean estado();
}
