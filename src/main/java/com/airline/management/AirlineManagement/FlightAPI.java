package com.airline.management.AirlineManagement;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightAPI {
    private final FlightDataStore FlightDataStore;

    public FlightAPI(FlightDataStore FlightDataStore) {
        this.FlightDataStore = FlightDataStore;
    }

    // Get all flights
    @GetMapping
    public List<Flight> getAllFlights() {
        return FlightDataStore.getAllFlights();
    }

    // Get flight by ID
    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Long id) {
        return FlightDataStore.getFlightById(id);
    }

    // Get flights by source & destination
    @GetMapping("/schedules")
    public List<Flight> getFlightsByRoute(@RequestParam String source, @RequestParam String destination) {
        return FlightDataStore.getAllFlights().stream()
                .filter(f -> f.getSource().equalsIgnoreCase(source) && f.getDestination().equalsIgnoreCase(destination))
                .toList();
    }

    // Get flight schedules by ID & date
    @GetMapping("/{id}/schedules")
    public List<String> getFlightSchedules(@PathVariable Long id, @RequestParam String dates) {
        Flight flight = FlightDataStore.getFlightById(id);
        if (flight != null && flight.getSchedule().contains(dates)) {
            return List.of(dates);
        }
        return List.of("No flights available on this date.");
    }
}
