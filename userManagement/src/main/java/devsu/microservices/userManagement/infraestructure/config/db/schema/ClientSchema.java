package devsu.microservices.userManagement.infraestructure.config.db.schema;

import devsu.microservices.userManagement.entity.client.model.Client;
import devsu.microservices.userManagement.entity.person.model.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Cliente")
public class ClientSchema extends PersonSchema {

    @Column(name = "contrasena", nullable = false)
    @NotBlank
    private String contrasena;

    @Column(name = "estado", nullable = false)
    @NotBlank
    private String estado;

    public Client toClient() {
        Client client = new Client(
                this.getId(),
                this.getNombre(),
                this.getGenero(),
                this.getEdad(),
                this.getIdentificacion(),
                this.getDireccion(),
                this.getTelefono(),
                this.contrasena,
                this.estado
        );
        return client;
    }

    public ClientSchema(Client client) {
        super(client);
        this.contrasena = client.getContrasena();
        this.estado = client.getEstado();
    }


    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String  getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}