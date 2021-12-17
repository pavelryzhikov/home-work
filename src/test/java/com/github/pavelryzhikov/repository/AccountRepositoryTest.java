package com.github.pavelryzhikov.repository;

import com.github.pavelryzhikov.dto.Account;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AccountRepositoryTest {
    @Mock
    Account account;

    AccountRepository accountRepository = Mockito.mock(AccountRepository.class);

    /**
     * проверка количества вызовов метода
     */
    @Test
    void callZeroTimesTest() throws FileNotFoundException {
        Set<Account> setAccount = new HashSet();
        setAccount.add(account);
        verify(accountRepository, times(0)).getAllAccountsByClientId(1L);

    }

}
