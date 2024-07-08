package devsu.microservices.userManagement.entity.person.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("User not found!");
    }
}