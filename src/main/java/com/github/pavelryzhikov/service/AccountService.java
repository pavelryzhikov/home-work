package com.github.pavelryzhikov.service;

import java.util.Set;

public class AccountService {

    private final AccountRepository accRep;

    public AccountService(AccountRepository accountRepository) {
        System.out.println("AccountRepository");
        accRep = accountRepository;
    }

    public boolean isAccountExist(long clientId, Account account) {
        Set<Account> allAccounts = accRep.getAllAccountsByClientId(clientId);
        return allAccounts.contains(account);
    }
}
