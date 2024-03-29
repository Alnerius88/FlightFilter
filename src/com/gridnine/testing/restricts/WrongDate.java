package com.gridnine.testing.restricts;

import com.gridnine.testing.сlasses.Flight;
import com.gridnine.testing.сlasses.Segment;

import java.util.function.Predicate;

public class WrongDate implements Restrict{

    /**
     * Переопределение метода rightFlight для фильтрации даты прилета раньше, чем дата вылета
     */
    @Override
    public boolean rightFlight (Flight flight) {
        Predicate<Segment> segmentPredicate=(segment) -> segment.getDepartureDate().isAfter(segment.getArrivalDate());
        return flight.getSegments().stream().anyMatch(segmentPredicate);
    }
}
