package com.example.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/test")
    public String home(Model model) {
        Car car = new Car(1L, "BMW", "i8");
        model.addAttribute("name", "Jakub");
        model.addAttribute("car", car);
        return "home";
    }

    @GetMapping("/car")
    public String getCars(Model model) {
        Iterable<Car> data = carService.getAllCars();
        model.addAttribute("cars", data);
        model.addAttribute("newCar", new Car());
        return "car";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car) {
        carService.addCar(car);
        return "redirect:/car";
    }
}
