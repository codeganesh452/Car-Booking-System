package com.example.demo.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/cars")
public class CarContoller {

	private final CarService carService;

	public CarContoller(CarService carService) {
		super();
		this.carService = carService;
	}
	
	@GetMapping("/all")
	public List<Car> getAll(){
		return carService.getAllCars();
	}
	
	@GetMapping("/available")
	public List<Car> getAvailable() {
		return carService.getAvailableCars();
	}
	
	@GetMapping("/{id}")
	public Car getByid(@PathVariable Integer id) {
		return carService.getCarById(id);
	}
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public Car addCar(@RequestBody Car car) {
		return carService.addcar(car);
	}
	
}
