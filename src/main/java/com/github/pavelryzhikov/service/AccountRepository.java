package com.github.pavelryzhikov.service;

import java.util.Set;

//@Slf4j
public interface AccountRepository {
    //private Set<Account> accountRepository;
    Set<Account> getAllAccountsByClientId(long clientId);
}
