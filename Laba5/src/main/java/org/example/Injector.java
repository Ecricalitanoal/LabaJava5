package org.example;

import org.example.annotation.AutoInjectable;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {

    private Properties properties;

    public Injector(String pathToProperty) {
        properties = new Properties();
        try (InputStream ins = Injector.class.getClassLoader().getResourceAsStream(pathToProperty)) {
            properties.load(ins);
        } catch (Exception e) {
            throw new RuntimeException("Error opening properties file", e);
        }
    }

    public <T> T inject(T object) {
        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                Class<?> fieldType = field.getType();

                String implementationNameClass = properties.getProperty(fieldType.getName());

                if (implementationNameClass == null) {
                    throw new RuntimeException("Error no implementation for interface " + fieldType.getName());
                }

                try {
                    Class<?> classImplementation = Class.forName(implementationNameClass);
                    Object instanceImplementation= classImplementation.getDeclaredConstructor().newInstance();
                    field.setAccessible(true);
                    field.set(object, instanceImplementation);
                } catch (Exception e) {
                    throw new RuntimeException("Injection error", e);
                }
            }
        }
        return object;
    }
}