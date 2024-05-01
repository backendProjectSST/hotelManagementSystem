package org.backendprojectsst.hotelmanagementsystem.services.BookingDetails;

import org.backendprojectsst.hotelmanagementsystem.models.BookingDetails;
import org.backendprojectsst.hotelmanagementsystem.models.BookingStatus;
import org.backendprojectsst.hotelmanagementsystem.models.PaymentMethod;
import org.backendprojectsst.hotelmanagementsystem.models.PaymentStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service

public interface BookingDetailsService {
    public void addBookingDetails(BookingDetails bookingDetails);
    public void updateBookingDetails(BookingDetails bookingDetails);
    public void deleteBookingDetails(long bookingDetailsId);
    public BookingDetails getBookingDetailsByBookingId(long bookingDetailsId);
    public List<BookingDetails> getAllBookingDetails();

    public List<BookingDetails> getBookingDetailsByCustomerId(long customerId);

    public List<BookingDetails> getBookingDetailsByRoomId(long roomId);


    public List<BookingDetails> getBookingDetailsByBookingStatus(BookingStatus status);

    public List<BookingDetails> getBookingDetailsByPaymentStatus(PaymentStatus paymentStatus);

    public List<BookingDetails> getBookingDetailsByPaymentMethod(PaymentMethod paymentMethod);

    public List<BookingDetails> getBookingDetailsByPaymentDate(LocalDate paymentDate);

    public List<BookingDetails> getBookingDetailsByCheckInTime(LocalTime checkInTime);

    public List<BookingDetails> getBookingDetailsByCheckOutTime(LocalTime checkOutTime);
}
