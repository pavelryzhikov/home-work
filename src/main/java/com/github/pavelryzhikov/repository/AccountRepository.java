package com.github.pavelryzhikov.repository;

import com.github.pavelryzhikov.dto.Account;

import java.util.Set;

/**
 * Класс интерфейс репозитарий хранящий счета
 */

public interface AccountRepository {

    /**
     * получение счетов по id клиента
     *
     * @param clientId id клиента
     * @return Set<Account>
     * список счетов
     */
    Set<Account> getAllAccountsByClientId(long clientId);

    /**
     * метод обновляет файл счетов клиентов по заданным параметрам
     *
     * @param clientId id клиента
     * @param account  номер счета
     */
    void updateFileByClientIdAndAccount(Long clientId, String account);
}
