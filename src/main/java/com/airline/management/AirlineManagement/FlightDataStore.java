package com.airline.management.AirlineManagement;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FlightDataStore {
    private final Map<Long, Flight> flightMap = new HashMap();

    public FlightDataStore() {
        flightMap.put(1L, new Flight(1L, "STU101", "StudyJet", "Nagpur", "Pune",
                Arrays.asList("2025-04-01", "2025-04-02", "2025-04-03"), "06:45 AM", "08:30 AM"));
    
        flightMap.put(2L, new Flight(2L, "CLG420", "CampusWings", "Hyderabad", "Goa",
                Arrays.asList("2025-04-04", "2025-04-05"), "01:00 PM", "03:15 PM"));
    
        flightMap.put(3L, new Flight(3L, "TCH404", "TechAir", "Mumbai", "Bangalore",
                Arrays.asList("2025-04-06", "2025-04-07"), "05:20 PM", "07:30 PM"));
    
        flightMap.put(4L, new Flight(4L, "FST202", "FestFly", "Delhi", "Jaipur",
                Arrays.asList("2025-04-08", "2025-04-09"), "08:00 AM", "09:10 AM"));
    }
    

    public List<Flight> getAllFlights() {
        return new ArrayList<>(flightMap.values());
    }

    public Flight getFlightById(Long id) {
        return flightMap.get(id);
    }
}
