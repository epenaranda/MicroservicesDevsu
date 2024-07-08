package devsu.microservices.userManagement.infraestructure.responses;

import java.util.List;

public class ApiResponse<T> {
    private final List<DataWrapper<T>> data;

    public ApiResponse(List<DataWrapper<T>> data) {
        this.data = data;
    }

    public List<DataWrapper<T>> getData() {
        return data;
    }
}
