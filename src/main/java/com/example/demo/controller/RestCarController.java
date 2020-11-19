package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@CrossOrigin(origins = "http://127.0.0.1:8000")
	@RequestMapping(value = "/rest/list-cars", method = RequestMethod.GET)
    public List<Car> pageVisit() {
		List<Car> cars = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader ("cars"));
			String         line = null;
		    while((line = reader.readLine()) != null) {
		    	Car car = new Car();
		    	car.setName(line);
	            cars.add(car);
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cars;
	}
	
}
