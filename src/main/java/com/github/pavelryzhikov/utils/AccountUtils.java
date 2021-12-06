package com.github.pavelryzhikov.utils;

import com.github.pavelryzhikov.dto.Account;

import java.util.Comparator;
import java.util.List;

public class AccountUtils {

    /**
     * Сортировка счетов по Id
     *
     * @param accounts Счет
     */
    public static void sortedById(List<Account> accounts) {
        accounts.sort(new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return Long.compare(o1.getId(), o2.getId());
            }
        });
    }

    /**
     * Сортировка счетов по Id, createDate
     *
     * @param accounts Счет
     */
    public static void sortedByIdDate(List<Account> accounts) {
        accounts.sort(new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                int result = Long.compare(o1.getId(), o2.getId());
                if (result == 0) {
                    result = o1.getCreateDate().compareTo(o2.getCreateDate());
                }
                return result;
            }
        });
    }

    /**
     * Сортировка счетов по Id, createDate, Balance
     *
     * @param accounts Счет
     */
    public static void sortedByIdDateBalance(List<Account> accounts) {
        accounts.sort(new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                int result = Long.compare(o1.getId(), o2.getId());
                if (result == 0) {
                    result = o1.getCreateDate().compareTo(o2.getCreateDate());
                    if (result == 0) {
                        result = o1.getBalance().compareTo(o2.getBalance());
                    }
                }
                return result;
            }
        });
    }

}
