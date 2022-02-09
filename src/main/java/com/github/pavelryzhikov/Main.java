package com.github.pavelryzhikov;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * песочница
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        List<String> al = new ArrayList<String>();
        al.addAll(Arrays.asList("1", "s", "as", "4"));

        System.out.println(al);
        al.stream().filter(s -> s.contains("s")).forEach(System.out::println);

        al.stream().filter(s -> {
                    try {
                        Integer.valueOf(s);
                        return true;
                    } catch (NumberFormatException ex) {
                        return false;
                    }
                }
        ).forEach(System.out::println);

        String a = "aaa";
        a.contains("2");
        Integer.parseInt("2");

    }
}
