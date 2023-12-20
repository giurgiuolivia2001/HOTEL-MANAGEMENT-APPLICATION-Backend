package ro.fortech.project.services.validators;


public interface Validator<T> {

    void validate(T t) throws Exception;

}
