package com.github.pavelryzhikov.calculator;

import java.io.IOException;
import java.io.IOException.*;

public class Calculator {

//       public static void main(String[] args) {
//           System.out.println(Calculator.class.getSimpleName()+"."+Calculator.class.getEnclosingMethod());
//           System.out.println(getMaxOfArray(new int[]{1,2,3,4}));
//       }

    public static int getAddition(int x, int y) {
        return Math.addExact(x,y);
    }

    public static int getSubtraction(int x, int y) {
        return Math.subtractExact(x,y);
    }

    public static int getMultiplication(int x, int y) {
        return java.lang.Math.multiplyExact(x, y);
    }

    public static double getDivision(double x, double y) {
        if (y == 0){
            throw new ArithmeticException("Division by zero");
        }
        return x / y;
    }

    public static int getPow(int x, int y) {
        int result = 1;
        for (int i = 0; i < y; i++) {
            result = Math.multiplyExact(x,result);
        }
        return result;
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
