package com.epam.rd.autotasks;

public class QuadraticEquation {
    public String solve(double a, double b, double c) {
        if(a == 0)
            throw new IllegalArgumentException();

        double d = b * b - 4 * a * c;

        if (d < 0) {
            return "no roots";
        }
        else{
            double x1 = (-b - Math.pow(d,0.5)) / (2 * a);

            if(d == 0)
                return String.valueOf(x1);

            double x2 = (-b + Math.pow(d,0.5)) / (2 * a);
            return x2 + " " + x1;
        }
    }

}