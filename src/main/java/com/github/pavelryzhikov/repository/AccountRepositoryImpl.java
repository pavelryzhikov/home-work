/**
 * класс репозитория
 */
package com.github.pavelryzhikov.repository;

import com.github.pavelryzhikov.dto.Account;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class AccountRepositoryImpl implements AccountRepository {

    private final String filePath;
    private final ArrayList<String> fileData = new ArrayList<>();
    private final Set<Account> repository = new HashSet<>();

    /**
     * Конструктор принимает на вход путь к файлу счетов клиентов
     *
     * @param path путь к файлу счетов клиентов
     */
    AccountRepositoryImpl(String path) {
        filePath = path;
    }


    /**
     * получение счетов по id клиента
     *
     * @param clientId id клиента
     * @return Set<Account>
     * список счетов
     */
    @SneakyThrows
    public Set<Account> getAllAccountsByClientId(long clientId) {
        if (!Files.exists(Paths.get(filePath))) {
            throw new FileNotFoundException("aaaa");
        }

        /**
         * чтение из файла
         */
        FileInputStream fileInputStream = new FileInputStream(filePath);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            while (bufferedReader.ready()) {
                fileData.add(bufferedReader.readLine());
            }
        }

        /**
         * заполнение репозитария
         */
        fillRepository(clientId);

        return repository;
    }

    /**
     * метод обновляет файл счетов клиентов по заданным параметрам
     *
     * @param clientId id клиента
     * @param account  номер счета
     */
    public void updateFileByClientIdAndAccount(Long clientId, String account) {
        log.debug("call updateFileByClientIdAndAccount");
    }

//    private void readFile(String path) throws IOException {
//        fileData = (ArrayList) Files.readAllLines(Paths.get(path));
//    }

    /**
     * Заполнение репозитория
     *
     * @param clientId id клиента
     */
    private void fillRepository(Long clientId) {
        int i = 0;
        String number = null;
        Long parsed_client_id = null;
        for (String a : fileData) {
            a = a.trim().replace(",", "").replace("\"", "");
            if (a.trim().equals("{")) {
                i++;
            }
            if (a.contains("clientId")) {
                parsed_client_id = Long.parseLong(a.replace("clientId: ", ""));
            }
            if (a.contains("number")) {
                number = a.replace("number: ", "");
            }
            if (a.trim().replace(",", "").equals("}") && clientId == parsed_client_id) {
                Account account = new Account(number);
                repository.add(account);
            }
        }
    }

}
