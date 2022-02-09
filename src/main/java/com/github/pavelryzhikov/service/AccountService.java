package com.github.pavelryzhikov.service;

import com.github.pavelryzhikov.dto.Account;
import com.github.pavelryzhikov.repository.Repository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Класс управляющий репозиторием счетов
 */

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AccountService {

    @NonNull Repository repository;

    /**
     * @param clientId id клиента
     * @param account  номер счета
     * @return boolean
     * возвращает ответ найден ли счет по id клиента
     */
    public boolean isAccountExist(long clientId, Account account) throws FileNotFoundException {
        return repository.getAllAccountsByClientId(clientId).contains(account);
    }

    public Account getMaxAccountBalance(long clientId) throws FileNotFoundException {
        try {
            return repository.getAllAccountsByClientId(clientId).stream().max(new Comparator<Account>() {
                @Override
                public int compare(Account o1, Account o2) {
                    return o1.getBalance().compareTo(o2.getBalance());
                }
            }).orElseThrow(FileNotFoundException::new);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }


    public Set getAllAccountsByDateMoreThen(long clientId, LocalDate minusDays) throws FileNotFoundException {
        try {
            return repository.getAllAccountsByClientId(clientId)
                    .stream()
                    .filter((a) -> a.getCreateDate().compareTo(minusDays) >= 0)
                    .collect(Collectors.toSet());
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }
}
