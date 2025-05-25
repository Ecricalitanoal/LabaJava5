package org.example.impls;

import org.example.interfaces.SomeInterface;

/**
 * Реализация интерфейса SomeInterface, выводящая "B".
 */
public class OtherImpl implements SomeInterface {
    /**
     * Выводит "B" в консоль.
     */
    @Override
    public void doSomething() {
        System.out.println("B");
    }
}
