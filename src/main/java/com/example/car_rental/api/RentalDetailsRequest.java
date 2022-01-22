package com.example.car_rental.api;

import lombok.Value;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
public class RentalDetailsRequest {

    @NotNull
    @Future
    LocalDate from;

    @NotNull
    @Future
    LocalDate to;

    @Min(0)
    Double price;

    @NotNull
    InsuranceOption insuranceOption;
}
