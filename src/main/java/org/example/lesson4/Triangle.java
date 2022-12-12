package org.example.lesson4;

public class Triangle {
    public double calcArea(int a, int b, int c) throws NegativeTriangleSideException, NonExistentTriangleException, ZeroTriangleSideException {
        if ((a < 0) || (b < 0) || (c < 0)) {
            throw new NegativeTriangleSideException();
        }
        if ((a == 0) || (b == 0) || (c == 0)) {
            throw new ZeroTriangleSideException();
        }
        if ((a + b <= c) || (b + c <= a) || (c + a <= b)) {
            throw new NonExistentTriangleException();
        }
        double p = (a + b + c) * 0.5;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
