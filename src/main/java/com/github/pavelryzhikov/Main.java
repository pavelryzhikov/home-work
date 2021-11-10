package com.github.pavelryzhikov;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List list = new List();
        list.add("qq");
        Set<Integer> si = new HashSet<>();
        si.add(1);

        System.out.println(si.toString());
    }
}
