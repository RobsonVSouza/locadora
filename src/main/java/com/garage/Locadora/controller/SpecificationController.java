package com.garage.Locadora.controller;

import com.garage.Locadora.dto.SpecificationDTO;
import com.garage.Locadora.service.SpecificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "specification")
public class SpecificationController {

    @Autowired
    SpecificationService specificationService;

    @PostMapping
    public ResponseEntity <SpecificationDTO> save(@RequestBody @Valid SpecificationDTO specificationDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(specificationService.save(specificationDTO));
    }

    @GetMapping
    public List <SpecificationDTO> findAll(){
        return specificationService.findAll();
    }
}
