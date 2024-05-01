package org.backendprojectsst.hotelmanagementsystem.services.Customer;

import org.backendprojectsst.hotelmanagementsystem.models.Customer;
import org.backendprojectsst.hotelmanagementsystem.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

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
}
