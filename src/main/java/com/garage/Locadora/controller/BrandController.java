package com.garage.Locadora.controller;

import com.garage.Locadora.dto.BrandDTO;
import com.garage.Locadora.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @PostMapping
    public ResponseEntity <BrandDTO> save(@RequestBody @Valid BrandDTO brandDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(brandService.save(brandDTO));
    }

    @GetMapping
    public List <BrandDTO> findAll(){
        return brandService.findAll();
    }

    @GetMapping("/{brandId}/cars")
    public BrandDTO getCarsByBrand(@PathVariable Long brandId) {
        return brandService.findBrandWithCars(brandId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(brandService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandDTO> update(@PathVariable Long id, @Valid @RequestBody BrandDTO brandDTO) {
        BrandDTO updatedBrand = brandService.update(id, brandDTO);
        return ResponseEntity.ok(updatedBrand);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id){
        brandService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
