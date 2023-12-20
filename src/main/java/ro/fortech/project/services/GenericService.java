package ro.fortech.project.services;

import ro.fortech.project.services.validators.exceptions.BlankException;

public class GenericService<T> {

    public void checkIfBlank(T t) throws BlankException
    {
        for (java.lang.reflect.Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value;
            try {
                value = field.get(t);
                System.out.println(field.getName() + " = " + value);
                if (value == null || value.toString().isBlank()) {
                    System.out.println("Aaaa");
                    throw new BlankException(field.getName() + " is blank");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
