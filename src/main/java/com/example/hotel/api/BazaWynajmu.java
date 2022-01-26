package com.example.hotel.api;


import com.example.hotel.domain.Wynajmy;
import com.example.hotel.domain.repository.KlientBaza;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/wynajm")
@AllArgsConstructor
public class BazaWynajmu {
    private UslugaWynajmu uslugaWynajmu;
    private KlientBaza klientBaza;
    @PostMapping("/nowyWynajm/{id}/{pokojId}")
    public Wynajmy nowyWynajm(@PathVariable Long id, @PathVariable Long pokojId, @RequestBody @Valid SzczegolyWynajmu szczegolyWynajmu) {
        return uslugaWynajmu.wynajmijPokoj(id, pokojId, szczegolyWynajmu);
    }
    @GetMapping("/wynajmyKlienta/{id}")
    public List<Wynajmy> getwynajmyKlienta(@PathVariable Long id) {
        return klientBaza.findById(id).get().getCustomerWynajmies();
    }

    @PostMapping("/zakonczWynajm/{id}")
    public void endRental(@PathVariable Long id) {
        uslugaWynajmu.zakonczWynajm(id);
    }
}
