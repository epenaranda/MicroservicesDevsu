package devsu.microservices.userManagement.infraestructure.config.db.schema;

import devsu.microservices.userManagement.entity.person.model.Gender;
import devsu.microservices.userManagement.entity.person.model.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Persona")
public abstract class PersonSchema extends AbstractEntitySchema<UUID> {


    @NotNull
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "genero", nullable = false, length = 1)
    private Gender genero;

    @NotNull
    @Min(0)
    @Max(100)
    @Column(name = "edad", nullable = false)
    private int edad;

    @NotNull
    @Column(name = "identificacion", unique = true, length = 20, nullable = false)
    private String identificacion;

    @NotNull
    @Column(name = "direccion", length = 255, nullable = false)
    private String direccion;

    @NotNull
    @Column(name = "telefono", length = 20, nullable = false)
    private String telefono;

    public PersonSchema() {
        // Constructor por defecto
    }

    public PersonSchema(Person person) {
        this.setId(person.getId());
        this.nombre = person.getNombre();
        this.genero = person.getGenero();
        this.edad = person.getEdad();
        this.identificacion = person.getIdentificacion();
        this.direccion = person.getDireccion();
        this.telefono = person.getTelefono();
    }

    // Getters and Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Gender getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = Gender.valueOf(genero);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
