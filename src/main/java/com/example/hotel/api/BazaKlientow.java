package com.example.hotel.api;


import com.example.hotel.domain.Klient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/Klient")
public class BazaKlientow {
    ObslugaKlienta obslugaKlienta;
    @PostMapping
    public Klient dodajklienta(@RequestBody DodajKlienta klient) {
        return obslugaKlienta.StworzKlienta(klient);
    }
}
