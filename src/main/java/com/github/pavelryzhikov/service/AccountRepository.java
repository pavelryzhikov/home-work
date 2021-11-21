package com.github.pavelryzhikov.service;

import java.util.Set;

/**
 * Класс репозитарий хранящий счета
 */

//@Slf4j
public interface AccountRepository {
    //private Set<Account> accountRepository;
    Set<Account> getAllAccountsByClientId(long clientId);
}