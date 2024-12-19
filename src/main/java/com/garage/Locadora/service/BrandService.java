package com.garage.Locadora.service;

import com.garage.Locadora.dto.BrandDTO;
import com.garage.Locadora.entity.Brand;
import com.garage.Locadora.exception.UnsupportedMathOperationException;
import com.garage.Locadora.mapper.BrandMapper;
import com.garage.Locadora.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    BrandMapper brandMapper;

    public BrandDTO save(BrandDTO brandDTO){
        Optional <Brand> brand = brandRepository.findByName(brandDTO.getName());
        if (brand.isPresent()){
            throw new UnsupportedMathOperationException("Já foi cadastrado");
        }
        return brandMapper.toDto(brandRepository.save(brandMapper.toEntity(brandDTO)));
    }

    public List<BrandDTO> findAll() {
        List <Brand> brand = brandRepository.findAll();
        return brand.stream()
                .map(brandMapper::toDto)
                .collect(Collectors.toList());
    }

    public BrandDTO update(Long id, BrandDTO brandDTO) {
        Brand existingBrand = brandRepository.findById(id)
                .orElseThrow(() -> new UnsupportedMathOperationException("Marca não encontrada com o ID " + id));

        Optional <Brand> brand = brandRepository.findByName(brandDTO.getName());
        if (brand.isPresent()){
            throw new UnsupportedMathOperationException("Já foi cadastrado");
        }

        brandMapper.updateEntityFromDto(brandDTO, existingBrand);
        Brand updateEntity = brandRepository.save(existingBrand);
        return brandMapper.toDto(updateEntity);
    }

    public BrandDTO findById(Long id){
        return brandRepository.findById(id)
                .map(brandMapper::toDto)
                .orElse(null);
    }

    public void delete(Long id) {
        if (!brandRepository.existsById(id)){
            throw new UnsupportedMathOperationException("Marca não encontrada com o ID " + id);
        }
        brandRepository.deleteById(id);
    }
}
