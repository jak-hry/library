package com.example.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public void addCar(Car car) {
        carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    public void removeCar(Car car) {
        carRepository.delete(car);
    }
}
