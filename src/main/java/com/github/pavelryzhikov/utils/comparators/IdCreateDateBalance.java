package com.github.pavelryzhikov.utils.comparators;

import com.github.pavelryzhikov.dto.Account;

import java.util.Comparator;

public class IdCreateDateBalance implements Comparator<Account> {

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
            return compareBalance(a1, a2);
        } else if (a1.getCreateDate().isAfter(a2.getCreateDate())) {
            return 1;
        } else {
            return -1;
        }
    }

    public int compareBalance(Account a1, Account a2) {
        return a1.getBalance().compareTo(a2.getBalance());
    }

}