package ro.fortech.project.services.validators.exceptions;

public class EmailTakenException extends Exception {

    public EmailTakenException(String message) {
        super(message);
    }
}
