package devsu.microservices.userManagement.infraestructure.responses;

public class DataWrapper<T> {
    private final String type;
    private final int id;
    private final T attributes;

    public DataWrapper(String type, int id, T attributes) {
        this.type = type;
        this.id = id;
        this.attributes = attributes;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public T getAttributes() {
        return attributes;
    }
}

