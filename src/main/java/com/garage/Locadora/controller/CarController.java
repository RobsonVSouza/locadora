package com.garage.Locadora.controller;

import com.garage.Locadora.dto.CarDTO;
import com.garage.Locadora.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "car")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping
    public ResponseEntity<CarDTO> save(@RequestBody @Valid CarDTO carDTO){
        return ResponseEntity.status(HttpStatus.OK).body(carService.save(carDTO));
    }

    @GetMapping
    public List <CarDTO> findAll(){
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(carService.findById(id));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<CarDTO> updateCar(@PathVariable Long id, @Valid @RequestBody CarDTO carDTO) {
//        CarDTO updateCar = carService.update(id, carDTO);
//        return ResponseEntity.ok(updateCar);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
