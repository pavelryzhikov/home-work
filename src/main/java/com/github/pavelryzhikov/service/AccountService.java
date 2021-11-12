package com.github.pavelryzhikov.service;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AccountService {

    @NonNull AccountRepository accRep;

    public boolean isAccountExist(long clientId, Account account) {
        return accRep.getAllAccountsByClientId(clientId).contains(account);
    }
}
