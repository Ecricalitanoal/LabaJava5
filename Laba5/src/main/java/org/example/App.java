package org.example;


/**
 * Демонстрирует работу механизма внедрения зависимостей.
 * Создает экземпляр SomeBean с внедренными зависимостями
 * в соответствии с конфигурационным файлом.
 */
public class App {
    /**
     * Точка входа в приложение.
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SomeBean sb = (new Injector("injector-second.properties")).inject(new SomeBean());
        sb.foo();
    }
}
