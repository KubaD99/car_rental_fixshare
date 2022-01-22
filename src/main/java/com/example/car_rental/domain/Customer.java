package com.example.car_rental.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@EqualsAndHashCode
@Getter
@Entity
public class Customer {


    public Customer(String fullName, Address address) {
        this.fullName = fullName;
        this.address = address;
        this.customerRentals = new ArrayList<>();
    }

    @Id
    @GeneratedValue
    Long id;

    String fullName;

    @OneToOne(cascade = CascadeType.ALL)
    Address address;

    @OneToMany(cascade = CascadeType.ALL)
    List<Rental> customerRentals;

    public void addRental(Rental rental){
        customerRentals.add(rental);
    }






}
