package org.backendprojectsst.hotelmanagementsystem.services.Customer;

import org.backendprojectsst.hotelmanagementsystem.models.Customer;

import java.util.List;

public interface CustomerService {
    public Customer getCustomerById(Long customerId);

    public Customer getCustomerByEmail(String email);

    public Customer getCustomerByContact(String contact);

    public Customer getCustomerByName(String name);

    public Customer getCustomerByRoomId(Long roomId);

    public Customer getCustomerByBookingId(Long bookingId);

    public List<Customer> getAllCustomers();

    public Customer createCustomer(Customer customer);

    public Customer updateCustomer(Long customerId, Customer updatedCustomer);

    public Customer checkIn(Long customerId);

    public Customer checkOut(Long customerId);

    Customer deleteCustomer(Long customerId);
}
