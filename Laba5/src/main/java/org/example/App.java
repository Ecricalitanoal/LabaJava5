package org.example;


public class App {
    public static void main(String[] args) {
        SomeBean sb = (new Injector("injector-second.properties")).inject(new SomeBean());
        sb.foo();
    }
}
