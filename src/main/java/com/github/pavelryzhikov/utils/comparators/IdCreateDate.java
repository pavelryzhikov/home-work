package com.github.pavelryzhikov.utils.comparators;

import com.github.pavelryzhikov.dto.Account;

import java.util.Comparator;

public class IdCreateDate implements Comparator<Account> {

    public int compare(Account a1, Account a2) {
        if (a1.getId() == a2.getId()) {
            return compareDate(a1, a2);
        } else if (a1.getId() > a2.getId()) {
            return 1;
        } else {
            return -1;
        }
    }

    public int compareDate(Account a1, Account a2) {
        if (a1.getCreateDate().isEqual(a2.getCreateDate())) {
            return 0;
        } else if (a1.getCreateDate().isAfter(a2.getCreateDate())) {
            return 1;
        } else {
            return -1;
        }
    }

}