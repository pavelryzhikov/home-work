package com.github.pavelryzhikov;

import com.github.pavelryzhikov.service.Account;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List list = new List();
        list.add("qq");
        Set<Integer> si = new HashSet<>();
        si.add(1);

        System.out.println(si.toString());

        Account account = new Account(null);
        //AccountService accountService = AccountService(null);
        Account acc = new Account("SDSD");
//        Account acc1 = Account.builder()
//                .account("asasas");

        System.out.println(account.getAccount());

        System.out.println(account.toString());
        System.out.println(account.hashCode());

        log.debug("foo");


    }
}
