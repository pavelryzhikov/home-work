package com.github.pavelryzhikov.repository;

import com.github.pavelryzhikov.dto.Account;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AccountRepositoryImpl implements AccountRepository {

    private final String filePath;
    private ArrayList<String> fileBytes;

    AccountRepositoryImpl(String path) {
        filePath = path;
    }

    @SneakyThrows
    public Set<Account> getAllAccountsByClientId(long clientId) {
        if (!Files.exists(Paths.get(filePath))) {
            throw new FileNotFoundException("aaaa");
        }

        readFile(filePath);

        int i = 0;
        Set<Account> repository = new HashSet<>();
        String number = null;
        Long parsed_client_id = null;
        for (String a : fileBytes) {
            a = a.trim().replace(",", "").replace("\"", "");
            if (a.trim().equals("{")) {
                System.out.println("start: " + a);
                i++;
            }
            if (a.contains("clientId")) {
                parsed_client_id = Long.parseLong(a.replace("clientId: ", ""));
            }
            if (a.contains("number")) {
                number = a.replace("number: ", "");
            }
            if (a.trim().replace(",", "").equals("}") && clientId == parsed_client_id) {
                System.out.println("end: " + a + " clientId=" + parsed_client_id + " number=" + number);
                Account account = new Account(number);
                repository.add(account);
            }
        }

        return repository;
    }


    private void readFile(String path) throws IOException {
        fileBytes = (ArrayList) Files.readAllLines(Paths.get(path));
    }
}
