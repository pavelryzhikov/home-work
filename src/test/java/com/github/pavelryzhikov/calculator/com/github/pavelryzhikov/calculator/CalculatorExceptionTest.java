package com.github.pavelryzhikov.calculator.com.github.pavelryzhikov.calculator;

import com.github.pavelryzhikov.calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorExceptionTest {
    @Test
    void getAdditionMaxValue(){
        assertEquals(2, Calculator.getAddition(1,1));
        //assertThrows(IOException(), Calculator.getAddition(Integer.MAX_VALUE,1));
    }

}
