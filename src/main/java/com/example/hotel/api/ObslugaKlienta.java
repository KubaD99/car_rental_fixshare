package com.example.hotel.api;

import com.example.hotel.domain.Klient;
import com.example.hotel.domain.repository.KlientBaza;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ObslugaKlienta {
    private final KlientBaza bazaKlientow;
    Klient StworzKlienta(DodajKlienta dodajKlienta) {
        return bazaKlientow.save(new Klient(dodajKlienta.getImieNazwisko(),
                dodajKlienta.getAdres()));
    }
}
