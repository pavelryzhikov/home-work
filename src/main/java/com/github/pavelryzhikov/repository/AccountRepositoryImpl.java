
package com.github.pavelryzhikov.repository;

import com.github.pavelryzhikov.dto.Account;
import com.github.pavelryzhikov.service.AccountService;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * класс репозитория
 */
@Slf4j
public class AccountRepositoryImpl implements AccountRepository {

    private final String filePath;

    /**
     * Конструктор принимает на вход путь к файлу счетов клиентов
     *
     * @param filePath путь к файлу счетов клиентов
     */
    AccountRepositoryImpl(String filePath) {
        this.filePath = filePath;
    }


    /**
     * получение счетов по id клиента
     *
     * @param clientId id клиента
     * @return Set<Account>
     * список счетов
     */

    public Set<Account> getAllAccountsByClientId(long clientId) throws FileNotFoundException {
        if (!Files.exists(Paths.get(filePath))) {
            throw new FileNotFoundException();
        }

        // чтение из файла
        List<String> fileData = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            while (bufferedReader.ready()) {
                fileData.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }

        // заполнение репозитории
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
        if (!accountService.isAccountExist(clientId, new Account(account))) {
            throw new IllegalArgumentException("счета " + account + " нет в файле");
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw");
        while (randomAccessFile.readByte() != 0) {
            String str = randomAccessFile.readLine();
            long endOfLinePointer = randomAccessFile.getFilePointer();
            int indexOfAccountInLine = str.lastIndexOf(account);
            if (indexOfAccountInLine != -1) {
                randomAccessFile.seek(endOfLinePointer - (str.length() - indexOfAccountInLine) - 1);
                randomAccessFile.writeBytes(new String(new char[account.length()]).replace("\0", "*"));
                break;
            }
        }
    }

    /**
     * Заполнение репозитория
     *
     * @param clientId id клиента
     */
    private Set<Account> fillRepository(Long clientId, List<String> fileData) {
        Set<Account> repository = new HashSet<>();
        String number = "";
        Long parsedClientId = 0L;
        for (String a : fileData) {
            a = a.trim().replace(",", "").replace("\"", "");
            if (a.contains("clientId")) {
                parsedClientId = Long.parseLong(a.replace("clientId: ", ""));
            }
            if (a.contains("number")) {
                number = a.replace("number: ", "");
            }
            if (a.trim().replace(",", "").equals("}") && clientId.compareTo(parsedClientId) == 0 && !number.isEmpty()) {
                Account account = new Account(number);
                repository.add(account);
            }
        }
        return repository;
    }

}
