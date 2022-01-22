package com.example.car_rental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


import javax.persistence.*;
import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@FieldDefaults(level = PRIVATE)
@Entity
@Setter
public class Rental {

    public Rental(Car car, LocalDate from, LocalDate to, Double price) {
        this.car = car;
        this.startDate = from;
        this.endDate = to;
        this.price = price;
    }

    @Id
    @GeneratedValue
    Long id;

    @OneToOne(cascade = CascadeType.ALL)
    Car car;

    LocalDate startDate;

    LocalDate endDate;

    Double price;

    Boolean isActive;


}
