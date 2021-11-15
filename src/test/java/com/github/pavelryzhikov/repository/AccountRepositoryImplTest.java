package com.github.pavelryzhikov.repository;

import com.github.pavelryzhikov.dto.Account;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryImplTest {

    AccountRepository accountRepository;

    /**
     * проверка корректной выдачи результата для id клиента = 1
     *
     * @throws FileNotFoundException
     */
    @Test
    void onlyPersonalAccounts() throws FileNotFoundException {
        accountRepository = new AccountRepositoryImpl("src/main/resources/Accounts.txt");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1);
        ArrayList<String> strings = new ArrayList<String>() {{
            add("2-ACCNUM");
            add("1-ACCNUM");
            add("4-ACC1NUM");
        }};

        allAccountsByClientId.forEach(e -> assertTrue(strings.contains(e.getNumber())));
    }

    /**
     * проверка наличия конкретного счета у id клиента = 1
     *
     * @throws FileNotFoundException
     */
    @Test
    void successGetAllAccountsByClientId() throws FileNotFoundException {
        accountRepository = new AccountRepositoryImpl("src/main/resources/Accounts.txt");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1);

        assertEquals(1, (int) allAccountsByClientId.stream().filter(e -> e.getNumber().equals("4-ACC1NUM")).count());
    }

    /**
     * проверка исключения чтения несуществующего файла
     */
    @Test
    void failGetAllAccountsByClientId() {
        accountRepository = new AccountRepositoryImpl("somePath");
        assertThrows(FileNotFoundException.class, () -> {
            accountRepository.getAllAccountsByClientId(1L);
        });
    }

    /**
     * проверка корректной выдачи результата для id клиента = 2
     *
     * @throws FileNotFoundException
     */
    @Test
    void accountsWithIdTwo() throws FileNotFoundException {
        accountRepository = new AccountRepositoryImpl("src/main/resources/Accounts.txt");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(2);
        ArrayList<String> strings = new ArrayList<String>() {{
            add("5-ACC1NUM");
        }};
        allAccountsByClientId.forEach(e -> assertTrue(strings.contains(e.getNumber())));
    }

    /**
     * проверка некорректной отдачи результата
     *
     * @throws FileNotFoundException
     */
    @Test
    void accountsWithIdThreeFail() throws FileNotFoundException {
        accountRepository = new AccountRepositoryImpl("src/main/resources/Accounts.txt");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(3);
        ArrayList<String> strings = new ArrayList<String>() {{
            add("5-ACC1NUM");
        }};
        allAccountsByClientId.forEach(e -> assertFalse(strings.contains(e.getNumber())));
    }

}