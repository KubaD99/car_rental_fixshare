package com.example.hotel.api;

import com.example.hotel.domain.Pokoj;
import com.example.hotel.domain.Klient;
import com.example.hotel.domain.Wynajmy;
import com.example.hotel.domain.repository.BazaPokoi;
import com.example.hotel.domain.repository.KlientBaza;
import com.example.hotel.domain.repository.RentalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;


import static org.springframework.http.HttpStatus.NOT_FOUND;

@Component
@AllArgsConstructor

public class UslugaWynajmu {
    private RentalRepository repository;
    private KlientBaza klientBaza;
    private BazaPokoi bazaPokoi;
    public Wynajmy wynajmijPokoj(Long klientId, Long pokojId, SzczegolyWynajmu szczegolyWynajmu) {
        final Klient klient = klientBaza.findById(klientId).orElseThrow(CustomerNotFoundException::new);
        final Pokoj pokoj = bazaPokoi.findById(pokojId).orElseThrow(PokojNotFoundException::new);
        Wynajmy newWynajmy = new Wynajmy(pokoj, szczegolyWynajmu.getFrom(), szczegolyWynajmu.getTo(), szczegolyWynajmu.getCena());
        klient.dodajWynajm(newWynajmy);
        pokoj.setRented(true);
        newWynajmy.setCzyAktualny(true);
        return repository.save(newWynajmy);
    }
    public void zakonczWynajm(Long rentalId) {
        final Wynajmy wynajmy = repository.findById(rentalId).orElseThrow(RentalNotFoundException::new);
        wynajmy.getPokoj().setRented(false);
        wynajmy.setCzyAktualny(false);
        repository.deleteById(rentalId);
    }
    @ResponseStatus(value = NOT_FOUND, reason = "Klient nie znaleziony")
    private static class CustomerNotFoundException extends RuntimeException {
    }
    @ResponseStatus(value = NOT_FOUND, reason = "Pokoj nie znaleziony")
    private static class PokojNotFoundException extends RuntimeException {
    }
    @ResponseStatus(value = NOT_FOUND, reason = "Wynajmy nie znalezione")
    private static class RentalNotFoundException extends RuntimeException {
    }

}
