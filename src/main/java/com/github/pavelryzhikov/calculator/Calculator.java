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
        long result = (long)x * (long)y;
        if((int)result != result){
            throw new ArithmeticException("integer overflow");
        }
        return (int)result;
    }

    public static double getDivision(double x, double y) {
        if (y == 0){
            throw new ArithmeticException("Division by zero");
        }
        return x / y;
    }

    public static int getPow(int x, int y) {
        long result = 1;
        for (int i = 0; i < y; i++) {
            result = result * x;
        }

        if((int)result != result){
            throw new ArithmeticException("integer overflow");
        }
        return (int)result;
    }


    public static double getHypot(double[] x) {
        if (x.length < 2) {
            throw new ArrayIndexOutOfBoundsException("Expect more then 2 values");
        }
        double sumOfSquaredArguments = 0;
        for (double i : x) {
            sumOfSquaredArguments = i * i + sumOfSquaredArguments;
        }
        return Math.sqrt(sumOfSquaredArguments);
    }

    public static int getMaxOfArray(int[] x) {
        if (x.length == 0) {
            throw new ArrayIndexOutOfBoundsException("Empty parameter");
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
