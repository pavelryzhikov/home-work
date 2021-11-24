package com.github.pavelryzhikov.utils;

import com.github.pavelryzhikov.dto.Account;

import java.util.List;

public class AccountUtils {

    /**
     * Сортировка счетов по Id
     *
     * @param accounts Счет
     */
    public static void sortedById(List<Account> accounts) {
        accounts.sort(Account::compareTo);
    }

    /**
     * Сортировка счетов по Id, createDate
     *
     * @param accounts Счет
     */
    public static void sortedByIdDate(List<Account> accounts) {
        accounts.sort(Account::compareTo);
    }

    /**
     * Сортировка счетов по Id, createDate, Balance
     *
     * @param accounts Счет
     */
    public static void sortedByIdDateBalance(List<Account> accounts) {
        accounts.sort(Account::compareTo);
    }

}
