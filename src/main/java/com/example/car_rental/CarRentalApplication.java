package com.example.car_rental;

import com.example.car_rental.domain.Car;
import com.example.car_rental.domain.Customer;
import com.example.car_rental.domain.Rental;
import com.example.car_rental.domain.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Collections;

@SpringBootApplication
public class CarRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarRentalApplication.class, args);
    }


    @Bean
    public CommandLineRunner dataInitializer(CustomerRepository customerRepository) {
        return (args) -> customerRepository.save(new Customer("customer", null));
    }
}
