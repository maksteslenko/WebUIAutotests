package org.example.lesson4;

public class NonExistentTriangleException extends RuntimeException{
    public NonExistentTriangleException() {
        super("Треугольник с заданными сторонами не существует!");
    }
}
