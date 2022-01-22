package com.example.car_rental.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.YearMonth;

import static lombok.AccessLevel.PRIVATE;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Getter
public class Car {

    public Car(String brand, String model, YearMonth yearOfProduction) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }

    @Id
    @GeneratedValue
    Long id;

    String brand;

    String model;

    YearMonth yearOfProduction;

    @Setter
    boolean isRented;


}
