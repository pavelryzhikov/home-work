package com.github.pavelryzhikov.repository;

import com.github.pavelryzhikov.dto.Account;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryImplTest {

    AccountRepository accountRepository;


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

    @Test
    void successGetAllAccountsByClientId() throws FileNotFoundException {
        accountRepository = new AccountRepositoryImpl("src/main/resources/Accounts.txt");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(1);

        assertEquals(1, (int) allAccountsByClientId.stream().filter(e -> e.getNumber().equals("4-ACC1NUM")).count());
    }

    @Test
    void failGetAllAccountsByClientId() {
        accountRepository = new AccountRepositoryImpl("somePath");
        assertThrows(FileNotFoundException.class, () -> {
            accountRepository.getAllAccountsByClientId(1L);
        });
    }

    @Test
    void accountsWithIdTwo() throws FileNotFoundException {
        accountRepository = new AccountRepositoryImpl("src/main/resources/Accounts.txt");
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(2);
        ArrayList<String> strings = new ArrayList<String>() {{
            add("5-ACC1NUM");
        }};
        allAccountsByClientId.forEach(e -> assertTrue(strings.contains(e.getNumber())));
    }

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