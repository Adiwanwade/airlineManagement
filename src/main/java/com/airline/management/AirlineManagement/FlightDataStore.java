package com.airline.management.AirlineManagement;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FlightDataStore {
    private final Map<Long, Flight> flightMap = new HashMap();

    public FlightDataStore() {
        flightMap.put(1L, new Flight(1L, "AI300", "Air India", "Delhi", "Mumbai",
                Arrays.asList("2025-03-20", "2025-03-21", "2025-03-22"), "09:30 AM", "11:45 AM"));

        flightMap.put(2L, new Flight(2L, "6E450", "IndiGo", "Bangalore", "Chennai",
                Arrays.asList("2025-03-22", "2025-03-23"), "02:15 PM", "03:40 PM"));
    }

    public List<Flight> getAllFlights() {
        return new ArrayList<>(flightMap.values());
    }

    public Flight getFlightById(Long id) {
        return flightMap.get(id);
    }
}
