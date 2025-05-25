package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для приложения.
 */
public class AppTest {
    /**
     * Тестирует работу с первым конфигурационным файлом.
     */
    @Test
    public void testFirstFile() {
        Injector injector = new Injector("injector-first.properties");
        injector.inject(new SomeBean()).foo();
        assertDoesNotThrow(() -> {
            App.main(new String[] {});
        });
    }

    /**
     * Тестирует работу со вторым конфигурационным файлом.
     */
    @Test
    public void testSecondFile() {
        Injector injector = new Injector("injector-second.properties");
        injector.inject(new SomeBean()).foo();
        assertDoesNotThrow(() -> {
            App.main(new String[] {});
        });
    }
    /**
     * Тестирует обработку null в конструкторе Injector.
     */
    @Test
    public void testNullParamConstructor() {
        assertThrows(Exception.class, () -> {
            new Injector(null);
        });
    }
    /**
     * Тестирует обработку null объекта для внедрения.
     */
    @Test
    public void testNullObject() {
        Injector injector = new Injector("injector-first.properties");
        assertThrows(Exception.class, () -> {
            injector.inject(null);
        });
    }
}