package com.github.pavelryzhikov.repository;

import com.github.pavelryzhikov.dto.Account;
import com.github.pavelryzhikov.service.AccountService;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Set;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryImplTest {

    AccountRepository accountRepository;
    private static final String FILE_PATH_CORRECT = "src/main/resources/Accounts.txt";
    private static final String UPDATED_FILE_PATH = "src/main/resources/AccountsUpdated.txt";

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
        accountRepository = new AccountRepositoryImpl(FILE_PATH_CORRECT);
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
        accountRepository = new AccountRepositoryImpl(FILE_PATH_CORRECT);
        Set<Account> allAccountsByClientId = accountRepository.getAllAccountsByClientId(3);
        ArrayList<String> strings = new ArrayList<String>() {{
            add("5-ACC1NUM");
        }};
        allAccountsByClientId.forEach(e -> assertFalse(strings.contains(e.getNumber())));
    }


    /**
     * проверка успешного маскирования счета для клиента с одим счетом
     *
     * @throws FileNotFoundException
     */
    @Test
    void updateClientSuccessWithOneAccount() throws IOException {
        Long clientId = 3L;
        String accountNumer = "3-ACCNUM";
        Account account = new Account(accountNumer);
        String maskedString = new String(new char[accountNumer.length()]).replace("\0", "*");
        Account accountMasked = new Account(maskedString);


        Files.copy(Paths.get(FILE_PATH_CORRECT), Paths.get(UPDATED_FILE_PATH), REPLACE_EXISTING);
        accountRepository = new AccountRepositoryImpl(UPDATED_FILE_PATH);

        /**
         * проверка что accountNumberFrom счет найден
         */

        assertTrue(new AccountService(accountRepository).isAccountExist(clientId, account));

        /**
         * проверка что accountNumberTo счет НЕ найден
         */

        assertFalse(new AccountService(accountRepository).isAccountExist(clientId, accountMasked));

        /**
         * обновляем счет и проверяем что он теперь содержится в файле
         */
        accountRepository.updateFileByClientIdAndAccount(clientId, accountNumer);

        assertTrue(new AccountService(accountRepository).isAccountExist(clientId, accountMasked));
    }

    /**
     * проверка успешного маскирования счета для клиента с несколькими счетами
     *
     * @throws FileNotFoundException
     */
    @Test
    void updateClientSuccessWithSeveralAccounts() throws IOException {
        Long clientId = 1L;
        String accountNumer = "4-ACC1NUM";
        Account account = new Account(accountNumer);
        String maskedString = new String(new char[accountNumer.length()]).replace("\0", "*");
        Account accountMasked = new Account(maskedString);


        Files.copy(Paths.get(FILE_PATH_CORRECT), Paths.get(UPDATED_FILE_PATH), REPLACE_EXISTING);
        accountRepository = new AccountRepositoryImpl(UPDATED_FILE_PATH);

        /**
         * проверка что accountNumberFrom счет найден
         */

        assertTrue(new AccountService(accountRepository).isAccountExist(clientId, account));

        /**
         * проверка что accountNumberTo счет НЕ найден
         */

        assertFalse(new AccountService(accountRepository).isAccountExist(clientId, accountMasked));

        /**
         * обновляем счет и проверяем что он теперь содержится в файле
         */
        accountRepository.updateFileByClientIdAndAccount(clientId, accountNumer);

        assertTrue(new AccountService(accountRepository).isAccountExist(clientId, accountMasked));
    }

    @Test
    void updateClientNotFound() {
        Long clientId = -1L;
        String account = "5-ACC1NUM";

        accountRepository = new AccountRepositoryImpl(FILE_PATH_CORRECT);
        assertThrows(IllegalArgumentException.class, () -> {
            accountRepository.updateFileByClientIdAndAccount(clientId, account);
        });
    }


    @Test
    void updateAccountNotFound() {
        Long clientId = 3L;
        String accountNumberFrom = "5-ACC1NUM";

        accountRepository = new AccountRepositoryImpl(FILE_PATH_CORRECT);
        assertThrows(IllegalArgumentException.class, () -> {
            accountRepository.updateFileByClientIdAndAccount(clientId, accountNumberFrom);
        });
    }

}