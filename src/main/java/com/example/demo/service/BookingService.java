package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Booking;
import com.example.demo.model.Car;
import com.example.demo.model.User;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.CarRepository;

import jakarta.transaction.Transactional;

@Service
public class BookingService {
private final BookingRepository bookingRepo;
private final CarRepository carRepo;
public BookingService(BookingRepository bookingRepo, CarRepository carRepo) {
	super();
	this.bookingRepo = bookingRepo;
	this.carRepo = carRepo;
}

@Transactional
public Booking bookCar(Booking booking, Integer carid, User user) {
	Car car=carRepo.findById(carid).orElseThrow(()-> new RuntimeException("car not found"));
	if(!"Available".equalsIgnoreCase(car.getStatus())) {
		throw new RuntimeException("car is not available for booking ");
	}
	car.setStatus("Booked");
	carRepo.save(car);
	booking.setCar(car);
	booking.setUser(user);
	return bookingRepo.save(booking);
}

public List<Booking> getBookingsByUser(User user) {
    return bookingRepo.findByUser(user);
}

public List<Booking> getAllBookings() {
    return bookingRepo.findAll();
}


}
