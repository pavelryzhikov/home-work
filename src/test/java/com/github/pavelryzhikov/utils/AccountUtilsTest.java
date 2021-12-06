package com.github.pavelryzhikov.utils;

import com.github.pavelryzhikov.dto.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class AccountUtilsTest {

    @Test
    void sortedById() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(Account.builder().id(3L).createDate(LocalDate.now()).balance(BigDecimal.TEN).build());
        accounts.add(Account.builder().id(1L).createDate(LocalDate.now()).balance(BigDecimal.TEN).build());
        accounts.add(Account.builder().id(3L).createDate(LocalDate.now()).balance(BigDecimal.TEN).build());
        accounts.add(Account.builder().id(2L).createDate(LocalDate.now()).balance(BigDecimal.TEN).build());

        AccountUtils.sortedById(accounts);

        Assertions.assertEquals(1L, accounts.get(0).getId());
        Assertions.assertEquals(2L, accounts.get(1).getId());
        Assertions.assertEquals(3L, accounts.get(2).getId());
        Assertions.assertEquals(3L, accounts.get(3).getId());

    }

    /**
     * тест счетов
     * | id | createDate | balance | number |
     * --------------------------------------
     * | 1L | now()-4    | 10.0    | null |
     * | 3L | now()-3    | 10.0    | null |
     * | 3L | now()-1    | 10.0    | null |
     * | 2L | now()      | 10.0    | null |
     */
    @Test
    void sortedByIdDate() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(Account.builder().id(1L).createDate(LocalDate.now().minusDays(4)).balance(BigDecimal.TEN).build());
        accounts.add(Account.builder().id(3L).createDate(LocalDate.now().minusDays(3)).balance(BigDecimal.TEN).build());
        accounts.add(Account.builder().id(3L).createDate(LocalDate.now().minusDays(1)).balance(BigDecimal.TEN).build());
        accounts.add(Account.builder().id(2L).createDate(LocalDate.now()).balance(BigDecimal.TEN).build());


        AccountUtils.sortedByIdDate(accounts);

        Assertions.assertEquals(1L, accounts.get(0).getId());
        Assertions.assertEquals(2L, accounts.get(1).getId());
        Assertions.assertEquals(LocalDate.now().minusDays(3), accounts.get(2).getCreateDate());
        Assertions.assertEquals(LocalDate.now().minusDays(1), accounts.get(3).getCreateDate());
    }

    /**
     * тест счетов
     * | id | createDate | balance | number |
     * --------------------------------------
     * | 1L | now()-4    | 10.0    | null |
     * | 3L | now()-3    | 10.0    | null |
     * | 3L | now()-1    | 10.0    | null |
     * | 2L | now()      | 10.0    | null |
     * | 3L | now()-3    | 9.0     | null |
     */
    @Test
    void sortedByIdDateBalance() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(Account.builder().id(1L).createDate(LocalDate.now().minusDays(4)).balance(BigDecimal.TEN).build());
        accounts.add(Account.builder().id(3L).createDate(LocalDate.now().minusDays(3)).balance(BigDecimal.TEN).build());
        accounts.add(Account.builder().id(3L).createDate(LocalDate.now().minusDays(1)).balance(BigDecimal.TEN).build());
        accounts.add(Account.builder().id(2L).createDate(LocalDate.now()).balance(BigDecimal.TEN).build());
        accounts.add(Account.builder().id(3L).createDate(LocalDate.now().minusDays(3)).balance(BigDecimal.TEN.subtract(BigDecimal.ONE)).build());


        AccountUtils.sortedByIdDateBalance(accounts);

        Assertions.assertEquals(1L, accounts.get(0).getId());
        Assertions.assertEquals(2L, accounts.get(1).getId());
        Assertions.assertEquals(LocalDate.now().minusDays(3), accounts.get(2).getCreateDate());
        Assertions.assertEquals(LocalDate.now().minusDays(3), accounts.get(3).getCreateDate());
        Assertions.assertEquals(BigDecimal.valueOf(9), accounts.get(2).getBalance());
        Assertions.assertEquals(BigDecimal.valueOf(10), accounts.get(3).getBalance());
        Assertions.assertEquals(LocalDate.now().minusDays(1), accounts.get(4).getCreateDate());
    }


}