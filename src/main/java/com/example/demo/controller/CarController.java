package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Car;

@Controller
public class CarController {
	
	@Autowired
	Car car;


	@GetMapping("/cars")
    public String listCars(Model model) {
		car.setColor("red");
		car.setName("LADA2110");
		List<Car> cars = new ArrayList<>();
		cars.add(car);
		cars.add(car);
		model.addAttribute("cars", cars);
		// имя шаблона Themyleaf
		return "cars"; 
	}
	
	@GetMapping("/cars-front")
    public String listCars() {
		return "cars-front"; 
	}
}
