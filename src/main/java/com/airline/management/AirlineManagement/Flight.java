package com.airline.management.AirlineManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    private Long id;
    private String flightNumber;
    private String airline;
    private String source;
    private String destination;
    private List<String> schedule; // List of available dates (as Strings for simplicity)
    private String takeoffTime;
    private String arrivalTime;
}
