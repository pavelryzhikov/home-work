package com.github.pavelryzhikov.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * класс данные Account (счет)
 * <p>
 * accNumber содержит только поле номер счета
 */

@Value
@Builder
public class Account {
   String number;
   long id;
   LocalDate createDate;
   BigDecimal balance;
}
