package com.github.pavelryzhikov.service;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
public class AccountRepository {

    private Set<Account> accountRepository;

    public Set<Account> getAllAccountsByClientId(long clientId) {
        return accountRepository;
    }
}
