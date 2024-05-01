package org.backendprojectsst.hotelmanagementsystem.services.BookingDetails;

import org.backendprojectsst.hotelmanagementsystem.models.*;
import org.backendprojectsst.hotelmanagementsystem.repositories.BookingDetailsRepository;
import org.backendprojectsst.hotelmanagementsystem.repositories.CustomerRepository;
import org.backendprojectsst.hotelmanagementsystem.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService{

    private final BookingDetailsRepository bookingDetailsRepository;
    private final CustomerRepository customerRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public BookingDetailsServiceImpl(BookingDetailsRepository bookingDetailsRepository, CustomerRepository customerRepository, RoomRepository roomRepository) {
        this.bookingDetailsRepository = bookingDetailsRepository;
        this.customerRepository = customerRepository;
        this.roomRepository = roomRepository;
    }

    public void addBookingDetails(BookingDetails bookingDetails) {
        Room room = bookingDetails.getRoom();
        Customer customer = bookingDetails.getCustomer();
        customerRepository.save(customer);
        roomRepository.save(room);
        bookingDetailsRepository.save(bookingDetails);
    }

    public void updateBookingDetails(BookingDetails bookingDetails) {
        bookingDetailsRepository.save(bookingDetails);
    }


    public void deleteBookingDetails(long bookingDetailsId) {
        bookingDetailsRepository.deleteById(bookingDetailsId);
    }

    public BookingDetails getBookingDetailsByBookingId(long bookingDetailsId) {
        return bookingDetailsRepository.findById(bookingDetailsId).orElse(null);
    }

    public List<BookingDetails> getAllBookingDetails() {
        return bookingDetailsRepository.findAll();
    }

    public List<BookingDetails> getBookingDetailsByCustomerId(long customerId) {
        return bookingDetailsRepository.findByCustomer_CustomerId(customerId);
    }

    public List<BookingDetails> getBookingDetailsByRoomId(long roomId) {
        return bookingDetailsRepository.findByRoom_RoomId(roomId);
    }

    @Override
    public List<BookingDetails> getBookingDetailsByBookingStatus(BookingStatus status) {
        return bookingDetailsRepository.findByBookingStatus(status);
    }

    public List<BookingDetails> getBookingDetailsByPaymentStatus(PaymentStatus paymentStatus) {
        return bookingDetailsRepository.findByPaymentStatus(paymentStatus);
    }

    public List<BookingDetails> getBookingDetailsByPaymentMethod(PaymentMethod paymentMethod) {
        return bookingDetailsRepository.findByPaymentMethod(paymentMethod);
    }

    public List<BookingDetails> getBookingDetailsByPaymentDate(LocalDate paymentDate) {
        return bookingDetailsRepository.findByPaymentDate(paymentDate);
    }

    public List<BookingDetails> getBookingDetailsByCheckInTime(LocalTime checkInTime) {
        return bookingDetailsRepository.findByCheckInTime(checkInTime);
    }

    public List<BookingDetails> getBookingDetailsByCheckOutTime(LocalTime checkOutTime) {
        return bookingDetailsRepository.findByCheckOutTime(checkOutTime);
    }

}
