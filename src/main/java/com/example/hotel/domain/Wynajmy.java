package com.example.hotel.domain;

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
public class Wynajmy {
    public Wynajmy(Pokoj pokoj, LocalDate from, LocalDate to, Double cena) {
        this.pokoj = pokoj;
        this.rozpoczecie = from;
        this.zakonczenie = to;
        this.cena = cena;
    }
    @Id
    @GeneratedValue
    Long id;
    @OneToOne(cascade = CascadeType.ALL)
    Pokoj pokoj;
    LocalDate rozpoczecie;
    LocalDate zakonczenie;
    Double cena;
    Boolean czyAktualny;
}
