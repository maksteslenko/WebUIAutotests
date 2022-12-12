package org.example.lesson4;

public class NegativeTriangleSideException extends RuntimeException{
    public NegativeTriangleSideException() {
        super("Задано отрицательное значение стороны треугольника!");
    }
}
