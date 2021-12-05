package com.github.pavelryzhikov.repository;

import com.github.pavelryzhikov.dto.Account;

import java.io.FileNotFoundException;
import java.io.IOException;
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
    Set<Account> getAllAccountsByClientId(long clientId) throws FileNotFoundException;

    /**
     * метод обновляет файл счетов клиентов по заданным параметрам
     *
     * @param clientId id клиента
     * @param account  номер счета который нужно найти
     */
    void updateFileByClientIdAndAccount(Long clientId, String account) throws IOException;
}
