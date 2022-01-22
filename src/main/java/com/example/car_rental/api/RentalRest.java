package com.example.car_rental.api;


import com.example.car_rental.domain.Rental;
import com.example.car_rental.domain.repository.CustomerRepository;
import com.example.car_rental.domain.repository.RentalRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rental")
@AllArgsConstructor
public class RentalRest {

    private RentalService rentalService;
    private CustomerRepository customerRepository;


    @GetMapping("/userRentals/{id}")
    public List<Rental> getUserRentals(@PathVariable Long id) {
        return customerRepository.findById(id).get().getCustomerRentals();
    }

    @PostMapping("/newRental/{id}/{carId}")
    public Rental createNewRental(@PathVariable Long id, @PathVariable Long carId, @RequestBody @Valid RentalDetailsRequest rentalDetailsRequest) {
        return rentalService.rentACar(id, carId, rentalDetailsRequest);
    }

    @PostMapping("/endRental/{id}")
    public void endRental(@PathVariable Long id) {
        rentalService.endRental(id);
    }


}
