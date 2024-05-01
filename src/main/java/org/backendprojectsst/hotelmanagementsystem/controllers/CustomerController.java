package org.backendprojectsst.hotelmanagementsystem.controllers;

import org.backendprojectsst.hotelmanagementsystem.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer updatedCustomer) {
        Customer updated = customerService.updateCustomer(customerId, updatedCustomer);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{customerId}/checkin")
    public ResponseEntity<Customer> checkIn(@PathVariable Long customerId) {
        Customer checkedInCustomer = customerService.checkIn(customerId);
        if (checkedInCustomer != null) {
            return new ResponseEntity<>(checkedInCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{customerId}/checkout")
    public ResponseEntity<Customer> checkOut(@PathVariable Long customerId) {
        Customer checkedOutCustomer = customerService.checkOut(customerId);
        if (checkedOutCustomer != null) {
            return new ResponseEntity<>(checkedOutCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{customerId}/booking/{bookingId}/cancel")
    public ResponseEntity<?> cancelBooking(@PathVariable Long customerId, @PathVariable Long bookingId) {
        customerService.cancelBooking(customerId, bookingId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{customerId}/booking/history")
    public ResponseEntity<List<Booking>> getBookingHistory(@PathVariable Long customerId) {
        List<Booking> bookingHistory = customerService.getBookingHistory(customerId);
        return new ResponseEntity<>(bookingHistory, HttpStatus.OK);
    }

    @GetMapping("/{customerId}/room")
    public ResponseEntity<Room> getRoomDetails(@PathVariable Long customerId) {
        Room roomDetails = customerService.getCustomerRoomDetails(customerId);
        if (roomDetails != null) {
            return new ResponseEntity<>(roomDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
