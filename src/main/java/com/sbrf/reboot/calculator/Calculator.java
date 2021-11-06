package com.sbrf.reboot.calculator;

import java.io.IOException.*;

public class Calculator {

    //   public static void main(String[] args) {
    //       System.out.println(Calculator.class.getSimpleName()+"."+Calculator.class.getEnclosingMethod());
    //   }

    public static int getAddition(int x, int y){
        return x+y;
    }

    public static int getSubtraction(int x, int y){
        return x-y;
    }

    public static int getMultiplication(int x, int y){
        return x*y;
    }

    public static int getDivision(int x, int y){
        return x/y;
    }

    public static int getPow(int x, int y){
        return x^y;
    }



    public static double getHypot(int[] x){
        int sumOfSquaredArguments=0;
        for (int i: x) {
            sumOfSquaredArguments=i^2+sumOfSquaredArguments;
        }
        return Math.sqrt(sumOfSquaredArguments);
    }

    public static double getMax(int[] x){
        if(x.length==0){
            throw new ArrayIndexOutOfBoundsException();
        }
        int maxOfArguments=x[0];
        for (int i: x) {
            if(maxOfArguments>i){
                maxOfArguments=i;
            }
        }
        return maxOfArguments;
    }


}
