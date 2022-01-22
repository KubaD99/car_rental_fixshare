package com.example.car_rental.api;


import com.example.car_rental.domain.Customer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerRest {


    CustomerService customerService;

    @PostMapping
    public Customer addNewCustomer(@RequestBody AddNewCustomerRequest customer) {
        return customerService.createAndSaveNewCustomer(customer);
    }
}
