package devsu.microservices.operationManagement;

import org.springframework.boot.SpringApplication;

public class TestOperationManagementApplication {

	public static void main(String[] args) {
		SpringApplication.from(OperationManagementApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
