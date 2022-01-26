package com.example.hotel;

import com.example.hotel.domain.Klient;
import com.example.hotel.domain.repository.KlientBaza;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HotelApp {
    public static void main(String[] args) {
        SpringApplication.run(HotelApp.class, args);
    }
    @Bean
    public CommandLineRunner dataInitializer(KlientBaza klientBaza) {
        return (args) -> klientBaza.save(new Klient("customer", null));
    }
}
