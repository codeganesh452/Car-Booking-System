package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Booking;
import com.example.demo.model.User;
import com.example.demo.service.BookingService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

	private final BookingService bookingService;
	private final UserService userService;
	public BookingController(BookingService bookingService, UserService userService) {
		super();
		this.bookingService = bookingService;
		this.userService = userService;
	}
	
	@PostMapping("/book/{carId}")
	public Booking bookCar(@PathVariable Integer carId, @RequestBody Booking book,@AuthenticationPrincipal UserDetails userDetails) {
		User user=userService.findByUsername(userDetails.getUsername()).orElseThrow();
		return bookingService.bookCar(book, carId, user);
	}
	@GetMapping("/my")
	public ResponseEntity<?> getMyBookings(@AuthenticationPrincipal UserDetails userDetails) {
	    User user = userService.findByUsername(userDetails.getUsername()).orElseThrow();
	    return ResponseEntity.ok(bookingService.getBookingsByUser(user));
	}
	@GetMapping("/all")
	public ResponseEntity<?> getAllBookings() {
	    return ResponseEntity.ok(bookingService.getAllBookings());
	}

}

