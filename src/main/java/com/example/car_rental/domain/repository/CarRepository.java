package com.example.car_rental.domain.repository;

import com.example.car_rental.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Long> {

    List<Car> findByIsRentedFalse();
}
