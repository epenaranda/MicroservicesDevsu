package devsu.microservices.userManagement.entity.client.model;

import devsu.microservices.userManagement.entity.person.model.Gender;
import devsu.microservices.userManagement.entity.person.model.Person;

import java.util.UUID;

public class Client extends Person {

    private String contrasena;
    private String estado;

    public Client() {

    }

    public Client(String nombre, Gender genero, int edad, String identificacion, String direccion, String telefono, String contrasena, String estado) {
        super(nombre, genero, edad, identificacion, direccion, telefono);
        this.contrasena = contrasena;
        this.estado = estado;
    }


    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return super.toString() + ", contrasena=" + contrasena + ", estado=" + estado;
    }
}
