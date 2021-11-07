package com.github.pavelryzhikov.calculator;

import com.github.pavelryzhikov.calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorExceptionTest {
    @Test
    void getAdditionMaxValue(){
        assertThrows(ArithmeticException.class,
                ()-> Calculator.getAddition(Integer.MAX_VALUE,1)
        );
    }

    @Test
    void getSubtraction(){
        assertThrows(ArithmeticException.class,
                ()-> Calculator.getSubtraction(Integer.MIN_VALUE,1)
        );
    }

    @Test
    void getMultiplication(){
        assertThrows(ArithmeticException.class,
                ()-> Calculator.getMultiplication(Integer.MIN_VALUE,2)
        );
    }

    @Test
    void getDivision(){
        assertThrows(ArithmeticException.class,
                ()-> Calculator.getDivision(Integer.MIN_VALUE,0)
        );
    }


    @Test
    void getPow(){
        assertThrows(ArithmeticException.class,
                ()-> Calculator.getPow(Integer.MIN_VALUE,2)
        );
    }

    @Test
    void getHypot(){
        double[] arr = {2};
        assertThrows(ArrayIndexOutOfBoundsException.class,
                ()-> Calculator.getHypot(arr)
        );
    }

    @Test
    void getMaxOfArray(){
        int[] arr = {};
        assertThrows(ArrayIndexOutOfBoundsException.class,
                ()-> Calculator.getMaxOfArray(arr)
        );
    }


}
