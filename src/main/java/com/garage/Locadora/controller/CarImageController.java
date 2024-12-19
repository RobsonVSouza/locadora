package com.garage.Locadora.controller;

import com.garage.Locadora.dto.CarImageDTO;
import com.garage.Locadora.service.CarImageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "car-image")
public class CarImageController {

    @Autowired
    CarImageService carImageService;

    @PostMapping
    public ResponseEntity<CarImageDTO> save(@RequestBody @Valid CarImageDTO carImageDTO){
        return ResponseEntity.status(HttpStatus.OK).body(carImageService.save(carImageDTO));
    }

    @GetMapping
    public List <CarImageDTO> findAll(){
        return carImageService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarImageDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(carImageService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity <CarImageDTO> updateCarImage(@PathVariable Long id, @Valid @RequestBody CarImageDTO carImageDTO){
        CarImageDTO updateCarImage = carImageService.update(id,carImageDTO);
        return ResponseEntity.ok(updateCarImage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carImageService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
