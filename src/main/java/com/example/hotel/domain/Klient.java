package com.example.hotel.domain;

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
public class Klient {
    public Klient(String imieNazwisko, Adres adres) {
        this.imieNazwisko = imieNazwisko;
        this.adres = adres;
        this.customerWynajmies = new ArrayList<>();
    }
    @Id
    @GeneratedValue
    Long id;
    String imieNazwisko;
    @OneToOne(cascade = CascadeType.ALL)
    Adres adres;
    @OneToMany(cascade = CascadeType.ALL)
    List<Wynajmy> customerWynajmies;
    public void dodajWynajm(Wynajmy wynajmy){
        customerWynajmies.add(wynajmy);
    }
}
