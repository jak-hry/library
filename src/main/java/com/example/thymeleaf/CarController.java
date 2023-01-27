package com.example.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private List<Car> cars;

    public CarController() {
        cars = new ArrayList<>();
    }

    @GetMapping("/test")
    public String home(Model model) {
        Car car = new Car(1, "BMW", "i8");
        model.addAttribute("name", "Jakub");
        model.addAttribute("car", car);
        return "home";
    }

    @GetMapping("/car")
    public String getCars(Model model) {
        model.addAttribute("cars", cars);
        model.addAttribute("newCar", new Car());
        return "car";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car) {
        cars.add(car);
        return "redirect:/car";
    }
}
