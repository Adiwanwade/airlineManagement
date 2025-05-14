package com.airline.management.AirlineManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private Long ticketId;
    private String passengerName;
    private String email;
    private Long flightId;
    private String travelDate;
    private LocalDateTime bookingTime;
}

