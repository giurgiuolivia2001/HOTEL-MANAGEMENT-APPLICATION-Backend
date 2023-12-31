package ro.fortech.project.services.validators;

import ro.fortech.project.services.validators.exceptions.EmailInvalidException;

public class EmailEligibilityValidator implements Validator<String> {
    public void validate(String email) throws EmailInvalidException {
        String regexPattern = "^(.+)@(\\S+)$";
        if (!email.matches(regexPattern)) throw new EmailInvalidException("Email is invalid");
    }
}
