package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

  private Integer id;
  private String name;
  private String model;
  private String color;
  private String price;
  private String status="Available";
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "Car [id=" + id + ", name=" + name + ", model=" + model + ", color=" + color + ", price=" + price
			+ ", status=" + status + "]";
}
public Car() {
	super();
	// TODO Auto-generated constructor stub
}
public Car(String name, String model, String color, String price, String status) {
	super();
	this.name = name;
	this.model = model;
	this.color = color;
	this.price = price;
	this.status = status;
}
   
}
