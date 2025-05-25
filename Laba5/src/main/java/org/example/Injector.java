package org.example;

import org.example.annotation.AutoInjectable;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;
/**
 * Реализует механизм внедрения зависимостей на основе аннотаций и конфигурационного файла.
 * Ищет поля, помеченные аннотацией @AutoInjectable, и инициализирует их экземплярами классов,
 * указанных в конфигурационном файле.
 */
public class Injector {

    private Properties properties;

    /**
     * Создает инжектор с указанным конфигурационным файлом.
     * @param pathToProperty путь к конфигурационному файлу
     * @throws RuntimeException если файл не найден или произошла ошибка при чтении
     */
    public Injector(String pathToProperty) {
        properties = new Properties();
        try (InputStream ins = Injector.class.getClassLoader().getResourceAsStream(pathToProperty)) {
            properties.load(ins);
        } catch (Exception e) {
            throw new RuntimeException("Error opening properties file", e);
        }
    }

    /**
     * Внедряет зависимости в переданный объект.
     * @param <T> тип объекта
     * @param object объект для внедрения зависимостей
     * @return объект с внедренными зависимостями
     * @throws RuntimeException если не найдена реализация интерфейса или произошла ошибка при внедрении
     */
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