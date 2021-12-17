package com.github.pavelryzhikov.service;

import com.github.pavelryzhikov.dto.Account;
import com.github.pavelryzhikov.repository.AccountRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;

/**
 * Класс управляющий репозиторием счетов
 */

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AccountService {

    @NonNull AccountRepository accRep;

    /**
     * @param clientId id клиента
     * @param account  номер счета
     * @return boolean
     * возвращает ответ найден ли счет по id клиента
     */
    public boolean isAccountExist(long clientId, Account account) throws FileNotFoundException {
        return accRep.getAllAccountsByClientId(clientId).contains(account);
    }
}
