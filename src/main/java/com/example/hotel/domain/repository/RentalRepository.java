package com.example.hotel.domain.repository;

import com.example.hotel.domain.Wynajmy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Wynajmy, Long> {

}
