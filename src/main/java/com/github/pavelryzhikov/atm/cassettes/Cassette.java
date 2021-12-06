package com.github.pavelryzhikov.atm.cassettes;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * класс реализующий сущность Кассета банкомата
 *
 * @param <T>
 */

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Cassette<T extends Banknote> {

    @NonNull List<T> cassetteStaff;

    /**
     * метод возвращает количество купюр в кассете
     *
     * @return Количество купюр в кассете
     */
    public int getCountBanknotes() {
        return cassetteStaff.size();
    }
}
