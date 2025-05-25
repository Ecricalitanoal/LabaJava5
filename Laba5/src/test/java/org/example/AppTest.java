package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AppTest {

    @Test
    public void testFirstFile() {
        Injector injector = new Injector("injector-first.properties");
        injector.inject(new SomeBean()).foo();
        assertDoesNotThrow(() -> {
            App.main(new String[] {});
        });
    }

    @Test
    public void testSecondFile() {
        Injector injector = new Injector("injector-second.properties");
        injector.inject(new SomeBean()).foo();
        assertDoesNotThrow(() -> {
            App.main(new String[] {});
        });
    }

    @Test
    public void testNullParamConstructor() {
        assertThrows(Exception.class, () -> {
            new Injector(null);
        });
    }

    @Test
    public void testNullObject() {
        Injector injector = new Injector("injector-first.properties");
        assertThrows(Exception.class, () -> {
            injector.inject(null);
        });
    }
}