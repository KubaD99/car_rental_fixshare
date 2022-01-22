package com.example.car_rental.api;

import com.example.car_rental.domain.Car;
import com.example.car_rental.domain.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/car")
public class CarRest {


    private final CarRepository carRepository;

    @PostMapping
    public Car addNewCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable Long id) {
        return carRepository.getById(id);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/available")
    public List<Car> getAllAvailableCars() {
        return carRepository.findByIsRentedFalse();
    }
}
