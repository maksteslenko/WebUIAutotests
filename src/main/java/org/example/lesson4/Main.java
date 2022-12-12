package org.example.lesson4;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        try {
            System.out.println(triangle.calcArea(100, 3, 4));
        } catch (NegativeTriangleSideException e) {
            e.printStackTrace();
        } catch (ZeroTriangleSideException e) {
            e.printStackTrace();
        } catch (NonExistentTriangleException e) {
            e.printStackTrace();
        }
    }
}
