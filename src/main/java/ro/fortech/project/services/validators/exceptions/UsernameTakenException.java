package ro.fortech.project.services.validators.exceptions;

public class UsernameTakenException extends Exception {

    public UsernameTakenException(String message) {
        super(message);
    }
}
