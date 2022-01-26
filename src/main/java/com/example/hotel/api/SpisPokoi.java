package com.example.hotel.api;

import com.example.hotel.domain.Pokoj;
import com.example.hotel.domain.repository.BazaPokoi;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/room")
public class SpisPokoi {
    private final BazaPokoi bazaPokoi;
    @PostMapping
    public Pokoj dodajPokoj(@RequestBody Pokoj pokoj) {
        return bazaPokoi.save(pokoj);
    }
    @GetMapping("/{id}")
    public Pokoj pokazPokoj(@PathVariable Long id) {
        return bazaPokoi.getById(id);
    }
    @GetMapping
    public List<Pokoj> pokazWszystkiePokoje() {
        return bazaPokoi.findAll();
    }
    @GetMapping("/dostepne")
    public List<Pokoj> pokazWszystkieDostepnePokoje() {
        return bazaPokoi.findByIsRentedFalse();
    }
}
