package com.github.pavelryzhikov.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExperimentalCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2","2,23"})
    void getHypotParameterized(String values){
        String[] parsedValues = values.split(",");
        double[] doubleArray = Arrays.stream(parsedValues).mapToDouble(Double::parseDouble).toArray();
            //Pair(Double.parseDouble(parsedValues[0],Double.parseDouble(parsedValues[0]));
        assertEquals(Math.hypot(Double.parseDouble(parsedValues[0]), Double.parseDouble(parsedValues[1])),Calculator.getHypot(doubleArray));
    }


    @ParameterizedTest
    @ValueSource(strings = {"1,2,3","3,5,11", "0,-2,-12","-100,-20,-90"})
    void getMaxOfArrayParameterized(String values){
        String[] arrayString = values.split(",");
        int[] array = Arrays.stream(arrayString).mapToInt(Integer::parseInt).toArray();
        Integer[] integerArray = Arrays.stream( array ).boxed().toArray( Integer[]::new );
        //ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(array));
        //Collection collection = Collections.list(arrayList);
        assertEquals((int) Collections.max(new ArrayList<>(Arrays.asList(integerArray))),Calculator.getMaxOfArray(array));
    }

}

