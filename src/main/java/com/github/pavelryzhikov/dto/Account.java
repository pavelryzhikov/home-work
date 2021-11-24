package com.github.pavelryzhikov.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * класс Account (счет)
 */

@Value
@Builder
public class Account implements Comparable<Account> {
   String number;
   Long id;
   LocalDate createDate;
   BigDecimal balance;

   @Override
   public int compareTo(Account o) {
      if (o == null) {
         throw new NullPointerException();
      }
      if (o.getId() == null) {
         throw new NullPointerException();
      }
      if (o.getCreateDate() == null) {
         throw new NullPointerException();
      }
      if (o.getCreateDate() == null) {
         throw new NullPointerException();
      }
      int resultCompare = getId().compareTo(o.getId());
      if (resultCompare == 0) {
         resultCompare = getCreateDate().compareTo(o.getCreateDate());
         if (resultCompare == 0) {
            return getBalance().compareTo(o.getBalance());
         }
      }
      return resultCompare;
   }
}
