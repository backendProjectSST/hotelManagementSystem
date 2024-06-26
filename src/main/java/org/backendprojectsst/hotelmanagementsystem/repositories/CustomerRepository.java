package org.backendprojectsst.hotelmanagementsystem.repositories;

import org.backendprojectsst.hotelmanagementsystem.models.BookingDetails;
import org.backendprojectsst.hotelmanagementsystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Customer findByEmail(String email);
    public Customer findByContact(String contact);
    public Customer findByName(String name);
    public Customer findCustomerByRoom_RoomId(Long roomId);

    public Customer findCustomerByBookingDetails_BookingId(long bookingDetails_bookingId);
}
