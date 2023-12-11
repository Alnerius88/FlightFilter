package com.gridnine.testing.restricts;

import com.gridnine.testing.сlasses.Flight;


/**
 *Интерфейс-родитель для классов-правил фильтрации
 */

public interface Restrict {
    boolean rightFlight (Flight flights);
}
