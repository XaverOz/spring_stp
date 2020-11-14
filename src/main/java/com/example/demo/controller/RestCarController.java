package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Car;

@RestController
@RequestMapping("/")
public class RestCarController {
	@Autowired
	Car car;
	
	@RequestMapping(value = "/rest/list-cars", method = RequestMethod.GET)
    public List<Car> pageVisit() {
		car.setColor("red");
		car.setName("LADA2110");
		List<Car> cars = new ArrayList<>();
		cars.add(car);
		cars.add(car);
		return cars;
	}
	
}
