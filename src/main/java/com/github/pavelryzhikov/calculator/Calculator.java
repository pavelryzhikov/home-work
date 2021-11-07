package com.github.pavelryzhikov.calculator;

import java.io.IOException;
import java.io.IOException.*;

public class Calculator {

//       public static void main(String[] args) {
//           System.out.println(Calculator.class.getSimpleName()+"."+Calculator.class.getEnclosingMethod());
//           System.out.println(getMaxOfArray(new int[]{1,2,3,4}));
//       }

    public static int getAddition(int x, int y) {
        int result = x + y;
        if (((result^x) & (result^y)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return x + y;
    }

    public static int getSubtraction(int x, int y) {
        int result = x - y;
        if (((x^y) & (x^result)) < 0) {
            throw new ArithmeticException("integer overflow");
        }
        return x - y;
    }

    public static int getMultiplication(int x, int y) {
        return x * y;
    }

    public static double getDivision(double x, double y) {
        return x / y;
    }

    public static int getPow(int x, int y) {
        int result = 1;
        for (int i = 0; i < y; i++) {
            result = result * x;
        }
        return result;
    }


    public static double getHypot(double[] x) {
        double sumOfSquaredArguments = 0;
        for (double i : x) {
            sumOfSquaredArguments = i * i + sumOfSquaredArguments;
        }
        return Math.sqrt(sumOfSquaredArguments);
    }

    public static int getMaxOfArray(int[] x) {
        if (x.length == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int maxOfArguments = x[0];
        for (int i : x) {
            if (i > maxOfArguments) {
                maxOfArguments = i;
            }
        }
        return maxOfArguments;
    }


}
