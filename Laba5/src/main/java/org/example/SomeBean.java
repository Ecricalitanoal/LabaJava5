package org.example;

import org.example.annotation.AutoInjectable;
import org.example.interfaces.SomeInterface;
import org.example.interfaces.SomeOtherInterface;

/**
 * Класс с зависимостями для внедрения.
 */
public class SomeBean {

    @AutoInjectable
    private SomeInterface field1;

    @AutoInjectable
    private SomeOtherInterface field2;

    /**
     * Вызывает методы внедренных зависимостей.
     */
    public void foo() {
        field1.doSomething();
        field2.doSomeOther();
    }
}