package org.backendprojectsst.hotelmanagementsystem.services.Customer;

import org.backendprojectsst.hotelmanagementsystem.models.Customer;
import org.backendprojectsst.hotelmanagementsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }


    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(customerId).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            // Update other fields as needed
            return customerRepository.save(existingCustomer);
        }
        return null;
    }

    public Customer checkIn(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null && !customer.isCheckedIn()) {
            customer.setCheckedIn(true);
            return customerRepository.save(customer);
        }
        return null;
    }

    public Customer checkOut(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null && customer.isCheckedIn()) {
            customer.setCheckedIn(false);
            return customerRepository.save(customer);
        }
        return null;
    }

    public void cancelBooking(Long customerId, Long bookingId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null) {
            List<Booking> bookings = customer.getBookings();
            for (Booking booking : bookings) {
                if (booking.getId().equals(bookingId)) {
                    // Update booking status to cancelled
                    booking.setStatus("Cancelled");
                    // Perform other actions if needed
                    customerRepository.save(customer);
                    return;
                }
            }
        }
    }

    public List<Booking> getBookingHistory(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null) {
            return customer.getBookings();
        }
        return null;
    }

    public Room getCustomerRoomDetails(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null && customer.isCheckedIn()) {
            return customer.getRoom();
        }
        return null;
    }
}
}
