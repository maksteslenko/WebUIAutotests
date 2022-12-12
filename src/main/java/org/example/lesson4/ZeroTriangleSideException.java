package org.example.lesson4;

public class ZeroTriangleSideException extends RuntimeException{
    public ZeroTriangleSideException() {
        super("Сторона треугольника не может быть равна нулю!");
    }
}
