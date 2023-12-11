package com.gridnine.testing.restricts;

import com.gridnine.testing.сlasses.Flight;
import com.gridnine.testing.сlasses.Segment;

import java.time.LocalDateTime;
import java.util.function.Predicate;

public class WrongTime implements Restrict {

    /**
     * Переопределение метода rightFlight для фильтрации времени вылета до текущего местного времени
     */
    @Override
    public boolean rightFlight (Flight flight) {
        Predicate<Segment> segmentPredicate=(segment)-> LocalDateTime.now().isAfter(segment.getDepartureDate());
        return flight.getSegments().stream().anyMatch(segmentPredicate);
    }
}
