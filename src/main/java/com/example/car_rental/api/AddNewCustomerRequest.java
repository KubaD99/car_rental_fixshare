package com.example.car_rental.api;

import com.example.car_rental.domain.Address;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Value
public class AddNewCustomerRequest {

    @NotEmpty
    String fullName;


    @NotNull
    Address address;
}
