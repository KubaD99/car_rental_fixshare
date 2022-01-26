package com.example.hotel.api;

import com.example.hotel.domain.Adres;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Value
public class DodajKlienta {
    @NotNull
    Adres adres;
    @NotEmpty
    String imieNazwisko;
}
