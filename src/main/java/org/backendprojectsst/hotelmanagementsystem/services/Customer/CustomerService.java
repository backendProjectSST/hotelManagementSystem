package org.backendprojectsst.hotelmanagementsystem.services.Customer;

import org.backendprojectsst.hotelmanagementsystem.models.Customer;

public interface CustomerService {
    public Customer createCustomer(Customer customer);

    public Customer updateCustomer(Long customerId, Customer updatedCustomer);

    public Customer checkIn(Long customerId);

    public Customer checkOut(Long customerId);
}
