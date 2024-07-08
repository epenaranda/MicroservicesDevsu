package devsu.microservices.userManagement.entity.person.model;

public enum Gender {
    M("Masculino"),
    F("Feminino");

    private final String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
