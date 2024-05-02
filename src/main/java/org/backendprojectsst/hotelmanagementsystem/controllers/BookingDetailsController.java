package org.backendprojectsst.hotelmanagementsystem.controllers;

import org.backendprojectsst.hotelmanagementsystem.models.BookingDetails;
import org.backendprojectsst.hotelmanagementsystem.models.BookingStatus;
import org.backendprojectsst.hotelmanagementsystem.models.PaymentMethod;
import org.backendprojectsst.hotelmanagementsystem.models.PaymentStatus;
import org.backendprojectsst.hotelmanagementsystem.services.BookingDetails.BookingDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/bookingDetails")
public class BookingDetailsController {
    private final BookingDetailsService bookingDetailsService;

    public BookingDetailsController(BookingDetailsService bookingDetailsService) {
        this.bookingDetailsService = bookingDetailsService;
    }

    @GetMapping("/{bookingDetailsId}")
    public BookingDetails getBookingDetailsById(@PathVariable long bookingDetailsId) {
        return bookingDetailsService.getBookingDetailsByBookingId(bookingDetailsId);
    }

    @GetMapping("/")
    public List<BookingDetails> getAllBookingDetails() {
        return bookingDetailsService.getAllBookingDetails();
    }

    @GetMapping("/customer/{customerId}")
    public List<BookingDetails> getBookingDetailsByCustomerId(@PathVariable long customerId) {
        return bookingDetailsService.getBookingDetailsByCustomerId(customerId);
    }

    @GetMapping("/room/{roomId}")
    public List<BookingDetails> getBookingDetailsByRoomId(@PathVariable long roomId) {
        return bookingDetailsService.getBookingDetailsByRoomId(roomId);
    }

    @GetMapping("/status/{status}")
    public List<BookingDetails> getBookingDetailsByBookingStatus(@PathVariable String status) {
        BookingStatus bookingStatus = BookingStatus.valueOf(status);
        return bookingDetailsService.getBookingDetailsByBookingStatus(bookingStatus);
    }

    @GetMapping("/paymentStatus/{status}")
    public List<BookingDetails> getBookingDetailsByPaymentStatus(@PathVariable String status) {
        PaymentStatus paymentStatus = PaymentStatus.valueOf(status);
        return bookingDetailsService.getBookingDetailsByPaymentStatus(paymentStatus);
    }

    @GetMapping("/paymentMode/{method}")
    public List<BookingDetails> getBookingDetailsByPaymentMethod(@PathVariable String method) {
        PaymentMethod paymentMethod = PaymentMethod.valueOf(method);
        return bookingDetailsService.getBookingDetailsByPaymentMethod(paymentMethod);
    }

    @GetMapping("/paymentDate/{date}")
    public List<BookingDetails> getBookingDetailsByPaymentDate(@PathVariable String date) {
        LocalDate paymentDate = LocalDate.parse(date);
        return bookingDetailsService.getBookingDetailsByPaymentDate(paymentDate);
    }

    @GetMapping("/checkInTime/{time}")
    public List<BookingDetails> getBookingDetailsByCheckInTime(@PathVariable String time) {
        LocalTime checkInTime = LocalTime.parse(time);
        return bookingDetailsService.getBookingDetailsByCheckInTime(checkInTime);
    }

    @GetMapping("/checkOutTime/{time}")
    public List<BookingDetails> getBookingDetailsByCheckOutTime(@PathVariable String time) {
        LocalTime checkOutTime = LocalTime.parse(time);
        return bookingDetailsService.getBookingDetailsByCheckOutTime(checkOutTime);
    }

    @PostMapping("/")
    public void addBookingDetails(@RequestBody BookingDetails bookingDetails) {
        bookingDetailsService.addBookingDetails(bookingDetails);
    }

    @PutMapping("/{id}")
    public void updateBookingDetails(@PathVariable long id, @RequestBody BookingDetails bookingDetails) {
        bookingDetailsService.updateBookingDetails(id, bookingDetails);
    }

    @DeleteMapping("/{bookingDetailsId}")
    public void deleteBookingDetails(@PathVariable long bookingDetailsId) {
        bookingDetailsService.deleteBookingDetails(bookingDetailsId);
    }





}
