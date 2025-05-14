package com.airline.management.AirlineManagement;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class TicketDataStore {
    private final Map<Long, Ticket> ticketMap = new HashMap<>();
    private Long ticketCounter = 1L;

    public Ticket bookTicket(String passengerName, String email, Long flightId, String travelDate) {
        Ticket ticket = new Ticket(ticketCounter++, passengerName, email, flightId, travelDate, LocalDateTime.now());
        ticketMap.put(ticket.getTicketId(), ticket);
        return ticket;
    }

    public List<Ticket> getAllTicket() {
        return new ArrayList<>(ticketMap.values());
    }

    public Ticket getTicketById(Long ticketId) {
        return ticketMap.get(ticketId);
    }

    public boolean cancelTicket(Long ticketId) {
        return ticketMap.remove(ticketId) != null;
    }
}
