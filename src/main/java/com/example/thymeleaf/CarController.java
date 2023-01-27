package com.example.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {

    private final CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/test")
    public String home(Model model) {
        Car car = new Car(1L, "BMW", "i8");
        model.addAttribute("name", "Jakub");
        model.addAttribute("car", car);
        return "home";
    }

    @GetMapping("/car")
    public String getCars(Model model) {
//        Iterable<Car> data = carRepository.findAll();
//        model.addAttribute("cars", data);
        model.addAttribute("newCar", new Car());
        return "car";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car) {
        carRepository.save(car);
        return "redirect:/car";
    }
}
