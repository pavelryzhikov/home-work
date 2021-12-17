package com.github.pavelryzhikov.dto;

import lombok.NonNull;
import lombok.Value;

/**
 * класс данные Account (счет)
 * <p>
 * accNumber содержит только поле номер счета
 */

@Value
public class Account {
   @NonNull String number;
}


