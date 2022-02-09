package com.github.pavelryzhikov.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * класс данные Account (счет)
 * <p>
 * accNumber содержит только поле номер счета
 */

@Data
@Builder
@AllArgsConstructor
public class Account {
   private String number;
   private long id;
   private LocalDate createDate;
   private BigDecimal balance;
   private long clientId;

   public Account(String number) {
      this.number = number;
   }
}


