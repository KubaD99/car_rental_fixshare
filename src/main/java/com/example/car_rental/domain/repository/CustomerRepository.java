package com.example.car_rental.domain.repository;

import com.example.car_rental.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
