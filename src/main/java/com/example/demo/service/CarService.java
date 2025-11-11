package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;

@Service
public class CarService {
private final CarRepository carRepo;

public CarService(CarRepository carRepo) {
	super();
	this.carRepo = carRepo;
}

public Car addcar(Car car) {
	return carRepo.save(car);
}

public List<Car> getAllCars(){
	return carRepo.findAll();
}

public List<Car> getAvailableCars(){
	return carRepo.findByStatus("Available");
}

public Car getCarById(Integer id) {
	return carRepo.findById(id).orElseThrow(()-> new RuntimeException("car not found"));
}
public Car updateStatus(Integer id , String status) {
	Car c=getCarById(id);
	c.setStatus(status);
	return carRepo.save(c);
}
}
