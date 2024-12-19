package com.garage.Locadora.service;

import com.garage.Locadora.dto.CategoriesDTO;
import com.garage.Locadora.entity.Categories;
import com.garage.Locadora.exception.UnsupportedMathOperationException;
import com.garage.Locadora.mapper.CategoriesMapper;
import com.garage.Locadora.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriesService {

    @Autowired
    CategoriesRepository categoriesRepository;

    @Autowired
    CategoriesMapper categoriesMapper;

    public CategoriesDTO save(CategoriesDTO categoriesDTO){
            Optional <Categories> categories = categoriesRepository.findByName(categoriesDTO.getName());
            if (categories.isPresent()){
                throw new UnsupportedMathOperationException("Já foi cadastrado");
            }
            return categoriesMapper.toDto(categoriesRepository.save(categoriesMapper.toEntity(categoriesDTO)));
    }

    public List <CategoriesDTO> findAll(){
        List <Categories> categories = categoriesRepository.findAll();
        return categories.stream()
                .map(categoriesMapper::toDto)
                .collect(Collectors.toList());
    }

    public CategoriesDTO findById(Long id){
        return categoriesRepository.findById(id)
                .map(categoriesMapper::toDto)
                .orElse(null);
    }

    public CategoriesDTO update(Long id, CategoriesDTO categoriesDTO){
        Categories existingCategories = categoriesRepository.findById(id)
                .orElseThrow(() -> new UnsupportedMathOperationException("Categoria não encontrada para o ID " + id));
        categoriesMapper.updateEntityFromDto(categoriesDTO,existingCategories);
        Categories updateCategories = categoriesRepository.save(existingCategories);
        return categoriesMapper.toDto(updateCategories);
    }

    public void delete(Long id){
        if (!categoriesRepository.existsById(id)){
            throw new UnsupportedMathOperationException("Categoria não encontrada para o ID " + id);
        }
        categoriesRepository.deleteById(id);
    }
}
