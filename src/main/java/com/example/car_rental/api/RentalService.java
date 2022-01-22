package com.example.car_rental.api;

import com.example.car_rental.domain.Car;
import com.example.car_rental.domain.Customer;
import com.example.car_rental.domain.Rental;
import com.example.car_rental.domain.repository.CarRepository;
import com.example.car_rental.domain.repository.CustomerRepository;
import com.example.car_rental.domain.repository.RentalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Component
@AllArgsConstructor
public class RentalService {

    private RentalRepository repository;
    private CustomerRepository customerRepository;
    private CarRepository carRepository;


    public Rental rentACar(Long customerId, Long carId, RentalDetailsRequest rentalDetailsRequest) {
        final Customer customer = customerRepository.findById(customerId).orElseThrow(CustomerNotFoundException::new);
        final Car car = carRepository.findById(carId).orElseThrow(CarNotFoundException::new);
        Rental newRental = new Rental(car, rentalDetailsRequest.getFrom(), rentalDetailsRequest.getTo(), rentalDetailsRequest.getPrice());
        customer.addRental(newRental);
        car.setRented(true);
        newRental.setIsActive(true);

        return repository.save(newRental);

    }

    public void endRental(Long rentalId) {
        final Rental rental = repository.findById(rentalId).orElseThrow(RentalNotFoundException::new);
        rental.getCar().setRented(false);
        rental.setIsActive(false);
        repository.deleteById(rentalId);
    }


    @ResponseStatus(value = NOT_FOUND, reason = "Customer not found")
    private static class CustomerNotFoundException extends RuntimeException {

    }

    @ResponseStatus(value = NOT_FOUND, reason = "Car not found")
    private static class CarNotFoundException extends RuntimeException {

    }

    @ResponseStatus(value = NOT_FOUND, reason = "Rental not found")
    private static class RentalNotFoundException extends RuntimeException {

    }


}
