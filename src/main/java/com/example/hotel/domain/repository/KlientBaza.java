package com.example.hotel.domain.repository;

import com.example.hotel.domain.Klient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KlientBaza extends JpaRepository<Klient, Long> {
}
