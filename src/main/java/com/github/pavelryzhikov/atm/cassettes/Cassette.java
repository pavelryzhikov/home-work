package com.github.pavelryzhikov.atm.cassettes;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Cassette<T extends Banknote> {

    @NonNull ArrayList<T> cassetteStaff;

    public int getCountBanknotes() {
        return cassetteStaff.size();
    }
}
