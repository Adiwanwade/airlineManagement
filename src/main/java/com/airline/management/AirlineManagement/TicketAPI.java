package com.airline.management.AirlineManagement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketAPI {
    private final TicketDataStore ticketDataStore;
    private final FlightDataStore flightDataStore;

    public TicketAPI(TicketDataStore ticketDataStore, FlightDataStore flightDataStore) {
        this.ticketDataStore = ticketDataStore;
        this.flightDataStore = flightDataStore;
    }

    @GetMapping("/health-check")
    public String healthCheck(){
        return "OK";
    }

    // 📌 1. Book a Ticket
    @PostMapping
    public ResponseEntity<?> bookTicket(@RequestBody Ticket ticketRequest) {
        Flight flight = flightDataStore.getFlightById(ticketRequest.getFlightId());

        // ✅ Validation: Check if flight exists
        if (flight == null) {
            return ResponseEntity.badRequest().body("Invalid flight ID.");
        }

        // ✅ Validation: Check if the selected date is available
        if (!flight.getSchedule().contains(ticketRequest.getTravelDate())) {
            return ResponseEntity.badRequest().body("Flight not available on the selected date.");
        }

        Ticket ticket = ticketDataStore.bookTicket(
                ticketRequest.getPassengerName(),
                ticketRequest.getEmail(),
                ticketRequest.getFlightId(),
                ticketRequest.getTravelDate()
        );

        return ResponseEntity.ok(ticket);
    }

    // 📌 2. Retrieve ALL Ticket Details
    @GetMapping
    public List<Ticket> getAllTicket() {
        return ticketDataStore.getAllTicket();
    }

    // 📌 2. Retrieve Ticket Details
    @GetMapping("/{ticketId}")
    public ResponseEntity<?> getTicket(@PathVariable Long ticketId) {
        Ticket ticket = ticketDataStore.getTicketById(ticketId);

        if (ticket == null) {
            return ResponseEntity.badRequest().body("Ticket not found.");
        }

        return ResponseEntity.ok(ticket);
    }

    // 📌 3. Cancel a Ticket
    @DeleteMapping("/{ticketId}")
    public ResponseEntity<?> cancelTicket(@PathVariable Long ticketId) {
        boolean isCanceled = ticketDataStore.cancelTicket(ticketId);

        if (!isCanceled) {
            return ResponseEntity.badRequest().body("Ticket not found or already canceled.");
        }

        return ResponseEntity.ok("Ticket canceled successfully.");
    }
}


