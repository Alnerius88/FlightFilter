package com.gridnine.testing;

import com.gridnine.testing.restricts.Restrict;
import com.gridnine.testing.restricts.TooLongWaiting;
import com.gridnine.testing.restricts.WrongDate;
import com.gridnine.testing.restricts.WrongTime;
import com.gridnine.testing.serices.FlightBuilder;
import com.gridnine.testing.сlasses.Flight;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        FlightBuilder flightBuilder;
        List<Flight> genFlights = FlightBuilder.createFlights();
        System.out.println("Первоначальный список полетов:");
        genFlights.forEach(System.out::println);

        List<Restrict> restricts = new ArrayList<>();
        restricts.add(new TooLongWaiting());
        restricts.add(new WrongDate());
        restricts.add(new WrongTime());

        List<Flight> flights = new ArrayList<>(genFlights);

        List<Flight> filteredFlights = setRestricts(flights, restricts);

        System.out.println("Полеты после фильтрации:");
        filteredFlights.forEach(System.out::println);
    }

    public static List<Flight> setRestricts(List<Flight> flights, List<Restrict> restricts) {
        Predicate<Flight> flightPredicate = (flight) -> {
            for (var restrict : restricts) {
                if (restrict.rightFlight(flight)) {
                    return true;
                }
            }
            return false;
        };
        flights.removeIf(flightPredicate);
        return flights;
    }
}