package io.nomizo.util;

public class MathUtils {

    public int add(int a, int b) {
        return a + b;
    }

    public int substract(int a, int b) {
        int c = a - b;
        return c;
    }

    public int multiply(int a, int b) {
       int  c = a * b;
        return c;
    }

    public int divide(int a, int b) {
        int c = a / b;
        return c;
    }

    public double squared(double a, double b) {
        double c = Math.pow(a, b);
        return c;
    }


    public double computeCircleArea(double radius) {
       double area = Math.PI * radius * radius;
        return area;
    }
}
