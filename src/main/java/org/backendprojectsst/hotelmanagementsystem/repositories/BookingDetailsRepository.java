package org.backendprojectsst.hotelmanagementsystem.repositories;

import org.backendprojectsst.hotelmanagementsystem.models.BookingDetails;
import org.backendprojectsst.hotelmanagementsystem.models.BookingStatus;
import org.backendprojectsst.hotelmanagementsystem.models.PaymentMethod;
import org.backendprojectsst.hotelmanagementsystem.models.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Long> {
    List<BookingDetails> findByCustomer_CustomerId(long customerId);

    List<BookingDetails> findByBookingStatus(BookingStatus bookingStatus);

    List<BookingDetails> findByPaymentStatus(PaymentStatus paymentStatus);

    List<BookingDetails> findByPaymentMethod(PaymentMethod paymentMethod);

    List<BookingDetails> findByPaymentDate(LocalDate paymentDate);

    List<BookingDetails> findByCheckInTime(LocalTime checkInTime);

    List<BookingDetails> findByCheckOutTime(LocalTime checkOutTime);

    List<BookingDetails> findByRoom_RoomId(long roomId);
}
