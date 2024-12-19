package com.garage.Locadora.mapper;

import com.garage.Locadora.dto.CategoriesDTO;
import com.garage.Locadora.entity.Categories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class CategoriesMapper {

    private static final Logger logger = LoggerFactory.getLogger(CarMapper.class);

    public CategoriesDTO toDto(Categories categories){
        if (categories == null){
            logger.warn("Tentativa de mapear um objeto nulo para CategoriesDTO.");
            return null;
        }
        CategoriesDTO categoriesDTO = new CategoriesDTO();

        categoriesDTO.setId(categories.getId());
        categoriesDTO.setName(categories.getName());
        categoriesDTO.setDescription(categories.getDescription());
        categoriesDTO.setCreatedAt(categories.getCreatedAt() != null ? categories.getCreatedAt() : Instant.now());
        return categoriesDTO;
    }

    public Categories toEntity (CategoriesDTO categoriesDTO){
        if (categoriesDTO == null){
            logger.warn("Tentativa de mapear um objeto nulo para Categories.");
            return null;
        }
        Categories categories = new Categories();

        categories.setId(categories.getId());
        categories.setName(categoriesDTO.getName());
        categories.setDescription(categoriesDTO.getDescription());
        categories.setCreatedAt(categoriesDTO.getCreatedAt() != null ? categoriesDTO.getCreatedAt() : Instant.now());
        return categories;
    }

    public void updateEntityFromDto (CategoriesDTO categoriesDTO, Categories categories){
        if (categoriesDTO == null || categories == null){
            logger.warn("Tentativa de mapear objetos nulos.");
            return;
        }
        categories.setId(categories.getId());
        categories.setName(categoriesDTO.getName());
        categories.setDescription(categoriesDTO.getDescription());
        categories.setCreatedAt(categoriesDTO.getCreatedAt() != null ? categoriesDTO.getCreatedAt() : Instant.now());
    }

}
