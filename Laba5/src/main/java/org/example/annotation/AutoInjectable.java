package org.example.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация для автоматического внедрения зависимостей.
 * Помечает поля, которые должны быть автоматически инициализированы
 * с помощью механизма внедрения зависимостей.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface AutoInjectable { }