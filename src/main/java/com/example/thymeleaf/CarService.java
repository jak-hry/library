package com.example.thymeleaf;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

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
