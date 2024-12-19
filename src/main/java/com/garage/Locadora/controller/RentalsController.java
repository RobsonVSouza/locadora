package com.garage.Locadora.controller;

import com.garage.Locadora.dto.RentalsDTO;
import com.garage.Locadora.service.RentalsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "rentals")
public class RentalsController {

    @Autowired
    RentalsService rentalsService;

    @PostMapping
    public ResponseEntity <RentalsDTO> save (@RequestBody @Valid RentalsDTO rentalsDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(rentalsService.save(rentalsDTO));
    }

    @GetMapping
    public List <RentalsDTO> findAll(){
        return rentalsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalsDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(rentalsService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalsDTO> update(@PathVariable Long id, @Valid @RequestBody RentalsDTO rentalsDTO){
        RentalsDTO updatedRentals = rentalsService.update(id,rentalsDTO);
        return ResponseEntity.ok(updatedRentals);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRentals(@PathVariable Long id){
        rentalsService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
