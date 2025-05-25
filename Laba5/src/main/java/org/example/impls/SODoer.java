package org.example.impls;

import org.example.interfaces.SomeOtherInterface;

/**
 * Реализация интерфейса SomeOtherInterface, выводящая "C".
 */
public class SODoer implements SomeOtherInterface {
    /**
     * Выводит "C" в консоль.
     */
    @Override
    public void doSomeOther() {
        System.out.println("C");
    }
}