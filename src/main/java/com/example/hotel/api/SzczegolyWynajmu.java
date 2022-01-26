package com.example.hotel.api;

import lombok.Value;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
public class SzczegolyWynajmu {
    @NotNull
    @Future
    LocalDate from;
    @NotNull
    @Future
    LocalDate to;
    @Min(0)
    Double cena;
}
