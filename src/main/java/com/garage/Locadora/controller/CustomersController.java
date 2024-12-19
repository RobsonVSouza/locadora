package com.garage.Locadora.controller;

import com.garage.Locadora.dto.CustomersDTO;
import com.garage.Locadora.service.CustomersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "customers")
public class CustomersController {

    @Autowired
    CustomersService customersService;

    @PostMapping
    public ResponseEntity <CustomersDTO> save(@RequestBody @Valid CustomersDTO customersDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(customersService.save(customersDTO));
    }

    @GetMapping
    public List <CustomersDTO> findAll(){
        return customersService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomersDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(customersService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity <CustomersDTO> update(@PathVariable Long id, @Valid @RequestBody CustomersDTO customersDTO){
        CustomersDTO updateCustomers = customersService.update(id, customersDTO);
        return ResponseEntity.ok(updateCustomers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomers(@PathVariable Long id){
        customersService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
