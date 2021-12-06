package com.github.pavelryzhikov.service;

import com.github.pavelryzhikov.dto.Account;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

/**
 * Класс управляющий репозиторием счетов
 */

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AccountService {

    @NonNull AccountRepository accRep;

    /**
     * @param clientId - id клиента
     * @param account  - счет
     * @return Boolean
     */
    public boolean isAccountExist(long clientId, Account account) {
        return accRep.getAllAccountsByClientId(clientId).contains(account);
    }
}
