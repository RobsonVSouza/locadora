package com.garage.Locadora.mapper;

import com.garage.Locadora.dto.BrandDTO;
import com.garage.Locadora.entity.Brand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class BrandMapper {

    private static final Logger logger = LoggerFactory.getLogger(BrandMapper.class);

    public BrandDTO toDto(Brand brand) {
        if (brand == null) {
            logger.warn("Tentativa de mapear um objeto nulo para BrandDTO.");
            return null;
        }
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setId(brand.getId());
        brandDTO.setName(brand.getName());
        brandDTO.setCreatedAt(brand.getCreatedAt() != null ? brand.getCreatedAt() : Instant.now());
        return brandDTO;
    }

    public Brand toEntity(BrandDTO brandDTO) {
        if (brandDTO == null) {
            logger.warn("Tentativa de mapear um objeto nulo para Brand.");
            return null;
        }
        Brand brand = new Brand();
        brand.setId(brandDTO.getId());
        brand.setName(brandDTO.getName());
        brand.setCreatedAt(brandDTO.getCreatedAt() != null ? brandDTO.getCreatedAt() : Instant.now());
        return brand;
    }

    public void updateEntityFromDto(BrandDTO brandDTO, Brand brand) {
        if (brandDTO == null || brandDTO == null){
            logger.warn("Tentativa de mapear objetos nulos");
            return;
        }

        brand.setName(brandDTO.getName());
        brand.setCreatedAt(brandDTO.getCreatedAt() != null ? brandDTO.getCreatedAt() : Instant.now());

    }
}