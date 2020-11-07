package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Car;

@RestController
@RequestMapping("/")
public class CarController {
	@Autowired
	Car car;
	
	@RequestMapping(value = "list-cars", method = RequestMethod.GET)
    public String pageVisit() {
		car.setColor("red");
		car.setName("LADA2110");
		return car.toString();
	}
}
