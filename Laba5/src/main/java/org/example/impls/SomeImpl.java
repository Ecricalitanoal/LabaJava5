package org.example.impls;

import org.example.interfaces.SomeInterface;

/**
 * Реализация интерфейса SomeInterface, выводящая "A".
 */
public class SomeImpl implements SomeInterface {
    /**
     * Выводит "A" в консоль.
     */
    @Override
    public void doSomething(){
        System.out.println("A");}
}
