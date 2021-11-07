package com.github.pavelryzhikov.calculator;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void getAddition() {
        assertEquals(9, Calculator.getAddition(4, 5));
    }

    @Test
    void getSubtraction() {
        assertEquals(-1, Calculator.getSubtraction(4, 5));
    }

    @Test
    void getMultiplication() {
        assertEquals(20, Calculator.getMultiplication(4, 5));
    }

    @Test
    void getDivision() {
        assertEquals(3, Calculator.getDivision(9, 3));
    }

    @Test
    void classHasSevenMethods(){
        assertEquals(7,Calculator.class.getMethods().length-Object.class.getMethods().length);
    }

    @Test
    void getPow(){
        assertEquals(1024,Calculator.getPow(2,10));
    }

    @Test
    void getHypot(){
        double[] doubleArray = new double[]{3.0, 4.0}; //=5.0
        assertEquals(5.0,Calculator.getHypot(doubleArray));
    }


    @Test
    void getMaxOfArray(){
        int[] array = {-1,2,-3,0};
        Integer[] integerArray = Arrays.stream( array ).boxed().toArray( Integer[]::new );
        assertEquals((int) Collections.max(new ArrayList<>(Arrays.asList(integerArray))),Calculator.getMaxOfArray(array));
    }

}

