package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Car;

@Controller
public class CarController {
	
	@Autowired
	Car car;


	@GetMapping("/cars")
    public String listCars(Model model) {
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
		model.addAttribute("cars", cars);
		// имя шаблона Themyleaf
		return "cars"; 
	}
	
	@GetMapping("/add-car")
    public String addCarView(Model model) {
		return "car-add"; 
	}
	
	@PostMapping(value = "/add-car")
    public RedirectView addCar(HttpServletRequest request) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("cars", true));
			writer.write(request.getParameter("car") + "\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new RedirectView("cars");
	}
	
	@GetMapping("/cars-front")
    public String listCars() {
		return "cars-front"; 
	}
}
