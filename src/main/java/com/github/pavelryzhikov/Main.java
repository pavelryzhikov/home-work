package com.github.pavelryzhikov;

import com.github.pavelryzhikov.calculator.Calculator;


public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(-2147483647&-1);
        result(1,1);
        result(Integer.MIN_VALUE,1);
        result(Integer.MIN_VALUE,Integer.MAX_VALUE);
        result(4,10);

    }

    public static void result(int x, int y){
        System.out.println("-----");
        int result = x-y;
        //int addition = Calculator.getSubtraction(Integer.MIN_VALUE,1);
        //System.out.println(x^y);
        System.out.println(result);
        System.out.println(x^y);
        System.out.println(x^result);
//        System.out.println(result |x);
//        System.out.println(result |y);
//        System.out.println((result |y)&(result |x));
        System.out.println((x ^ y)&(x ^ result));

        //Math.subtractExact()
        //(((x ^ y) & (x ^ r)) < 0)
        //  x   y  (x-y) (x^y)   (x^r)   ((x ^ y) & (x ^ r))
        //  0   0  0     0       0       0
        //  1   1   0    0      1       0
      // -MIN48 1  MAX -MIN+1    -1

        int[] arr = {};
        int[] arr1 = new int[] {};

    }
}
