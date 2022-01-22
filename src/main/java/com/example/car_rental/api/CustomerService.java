package com.example.car_rental.api;

import com.example.car_rental.domain.Customer;
import com.example.car_rental.domain.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    Customer createAndSaveNewCustomer(AddNewCustomerRequest addNewCustomerRequest) {
        return customerRepository.save(new Customer(addNewCustomerRequest.getFullName(),
                addNewCustomerRequest.getAddress()));
    }
}
