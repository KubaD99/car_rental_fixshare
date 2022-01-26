package com.example.hotel.domain.repository;

import com.example.hotel.domain.Pokoj;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BazaPokoi extends JpaRepository<Pokoj,Long> {

    List<Pokoj> findByIsRentedFalse();
}
