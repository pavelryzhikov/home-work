package com.github.pavelryzhikov.atm.cassettes;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;

/**
 * класс реализующий сущность Кассета банкомата
 *
 * @param <T>
 */

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Cassette<T extends Banknote> {

    @NonNull ArrayList<T> cassetteStaff;

    /**
     * метод возвращает количество купюр в кассете
     *
     * @return
     */
    public int getCountBanknotes() {
        return cassetteStaff.size();
    }
}
