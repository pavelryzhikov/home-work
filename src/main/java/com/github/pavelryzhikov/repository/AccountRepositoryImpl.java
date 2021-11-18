/**
 * класс репозитория
 */
package com.github.pavelryzhikov.repository;

import com.github.pavelryzhikov.dto.Account;
import com.github.pavelryzhikov.service.AccountService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class AccountRepositoryImpl implements AccountRepository {

    private final String filePath;

    /**
     * Конструктор принимает на вход путь к файлу счетов клиентов
     *
     * @param path путь к файлу счетов клиентов
     */
    AccountRepositoryImpl(String path) //throws FileNotFoundException
    {
        // TODO: 11/17/21 попробовать добавить проверку в конструктор
        filePath = path;
//        if (!Files.exists(Paths.get(filePath))) {
//            throw new FileNotFoundException();
//        }
    }


    /**
     * получение счетов по id клиента
     *
     * @param clientId
     *        id клиента
     * @return Set<Account>
     * список счетов
     */
    @SneakyThrows
    public Set<Account> getAllAccountsByClientId(long clientId) {
        if (!Files.exists(Paths.get(filePath))) {
            throw new FileNotFoundException();
        }

        /**
         * чтение из файла
         */
        ArrayList<String> fileData = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            while (bufferedReader.ready()) {
                fileData.add(bufferedReader.readLine());
            }
        }

        /**
         * заполнение репозитария
         */


        return fillRepository(clientId, fileData);
    }

    /**
     * метод обновляет файл счетов клиентов по заданным параметрам
     *
     * @param clientId
     *        id клиента
     * @param account
     *        номер счета который нужно найти
     */
    public void updateFileByClientIdAndAccount(Long clientId, String account) throws IOException {
        log.debug("call updateFileByClientIdAndAccount");
        AccountService accountService = new AccountService(this);
        if (!accountService.isAccountExist(clientId, new Account(account)))
            throw new IllegalArgumentException("счета " + account + " нет в файле");
        long ass;
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");
        while (randomAccessFile.readByte() != 0) {
            String str = randomAccessFile.readLine();
            ass = randomAccessFile.getFilePointer();
            int indexOfAccountInLine = str.lastIndexOf(account);
            if (indexOfAccountInLine != -1) {
                randomAccessFile.seek(ass - (str.length() - indexOfAccountInLine) - 1);
                randomAccessFile.writeBytes(new String(new char[account.length()]).replace("\0", "*"));
                break;
            }
        }
    }


//    private void readFile(String path) throws IOException {
//        fileData = (ArrayList) Files.readAllLines(Paths.get(path));
//    }

    /**
     * Заполнение репозитория
     *
     * @param clientId id клиента
     */
    private Set<Account> fillRepository(Long clientId, ArrayList<String> fileData) {
        int i = 0;
        Set<Account> repository = new HashSet<>();
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
        return repository;
    }

}
