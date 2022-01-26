package com.example.hotel.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static lombok.AccessLevel.PRIVATE;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Getter
public class Pokoj {
    public Pokoj(String standard, String wielkosc) {
        this.standard = standard;
        this.wielkosc = wielkosc;
    }
    @Id
    @GeneratedValue
    Long id;
    String standard;
    String wielkosc;

    @Setter
    boolean isRented;
}
