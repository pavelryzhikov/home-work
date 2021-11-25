package com.github.pavelryzhikov.utils.comparators;

import com.github.pavelryzhikov.dto.Account;

import java.util.Comparator;

public class Id implements Comparator<Account> {
    public int compare(Account a1, Account a2) {
        if (a1.getId() == a2.getId()) {
            return 0;
        } else if (a1.getId() > a2.getId()) {
            return 1;
        } else {
            return -1;
        }

    }

}