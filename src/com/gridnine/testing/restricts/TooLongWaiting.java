package com.gridnine.testing.restricts;

import com.gridnine.testing.сlasses.Flight;
import com.gridnine.testing.сlasses.Segment;

import java.time.Duration;
import java.util.List;

public class TooLongWaiting implements Restrict{

    /**
     * Переопределение метода rightFlight для фильтрации ожидания свыше 2ух часов между сегментами
     */
    @Override
    public boolean rightFlight(Flight flight) {
        if (flight.getSegments().size() <= 1) {
            return false;
        }
        int min = 0;
        List<Segment> segmentList = flight.getSegments();
        for (int i = 1; i < segmentList.size(); i++) {
            Duration duration = Duration.between(segmentList.get(i - 1).getArrivalDate(), segmentList.get(i).getDepartureDate());
            min += (int) duration.toMinutes();
        }
        return min > 120;
    }
}
