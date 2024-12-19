package com.garage.Locadora.controller;

import com.garage.Locadora.dto.CategoriesDTO;
import com.garage.Locadora.service.CategoriesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "categories")
public class CategoriesController {

    @Autowired
    CategoriesService categoriesService;

    @PostMapping
    public ResponseEntity<CategoriesDTO> save(@RequestBody @Valid CategoriesDTO categoriesDTO){
        return ResponseEntity.status(HttpStatus.OK).body(categoriesService.save(categoriesDTO));
    }

    @GetMapping
    public List <CategoriesDTO> findAll(){
        return categoriesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriesDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(categoriesService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriesDTO> updateCategories(@PathVariable Long id, @Valid @RequestBody CategoriesDTO categoriesDTO){
        CategoriesDTO updateCategories = categoriesService.update(id, categoriesDTO);
        return ResponseEntity.ok(updateCategories);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoriesService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
