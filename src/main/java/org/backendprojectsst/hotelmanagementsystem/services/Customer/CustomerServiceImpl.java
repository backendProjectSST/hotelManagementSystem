package org.backendprojectsst.hotelmanagementsystem.services.Customer;

import org.backendprojectsst.hotelmanagementsystem.models.Customer;
import org.backendprojectsst.hotelmanagementsystem.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public Customer getCustomerByContact(String contact) {
        return customerRepository.findByContact(contact);
    }

    public Customer getCustomerByName(String name) {
        return customerRepository.findByName(name);
    }

    public Customer getCustomerByRoomId(Long roomId) {
        return customerRepository.findCustomerByRoom_RoomId(roomId);
    }

    public Customer getCustomerByBookingId(Long bookingId) {
        return customerRepository.findCustomerByBookingDetails_BookingId(bookingId);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(customerId).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            return customerRepository.save(existingCustomer);
        }
        return null;
    }

    public Customer checkIn(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null && !customer.getIsCheckedIn()) {
            customer.setIsCheckedIn(true);
            return customerRepository.save(customer);
        }
        return null;
    }

    public Customer checkOut(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null && customer.getIsCheckedIn()) {
            customer.setIsCheckedIn(false);
            return customerRepository.save(customer);
        }
        return null;
    }
}
