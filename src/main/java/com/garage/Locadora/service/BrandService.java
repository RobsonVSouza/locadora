package com.garage.Locadora.service;

import com.garage.Locadora.dto.BrandDTO;
import com.garage.Locadora.dto.CarDTO;
import com.garage.Locadora.entity.Brand;
import com.garage.Locadora.exception.UnsupportedMathOperationException;
import com.garage.Locadora.mapper.BrandMapper;
import com.garage.Locadora.mapper.CarMapper;
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

    @Autowired
    CarMapper carMapper;

    public BrandDTO save(BrandDTO brandDTO){
        Optional <Brand> brand = brandRepository.findByName(brandDTO.getName());
        if (brand.isPresent()){
            throw new UnsupportedMathOperationException("Já foi cadastrado");
        }
        return brandMapper.toDto(brandRepository.save(brandMapper.toEntity(brandDTO)));
    }

    public List<BrandDTO> findAll() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream()
                .map(brand -> {
                    BrandDTO brandDTO = brandMapper.toDto(brand);
                    brandDTO.setCars(brand.getCars().stream().map(carMapper::toDto).collect(Collectors.toList()));
                    return brandDTO;
                })
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

//    public BrandDTO findBrandWithCars(Long id) {
//        Brand brand = brandRepository.findById(id)
//                .orElseThrow(() -> new UnsupportedMathOperationException("Marca não encontrada com o ID " + id));
//
//        BrandDTO brandDTO = brandMapper.toDto(brand);
//        brandDTO.setCars(
//                brand.getCars().stream().map(car -> {
//                    CarDTO carDTO = new CarDTO();
//                    carDTO.setId(car.getId());
//                    carDTO.setName(car.getName());
//                    carDTO.setDescription(car.getDescription());
//                    carDTO.setDailyRate(car.getDailyRate());
//                    carDTO.setAvaliable(car.getAvaliable());
//                    carDTO.setLicensePlate(car.getLicensePlate());
//                    carDTO.setColor(car.getColor());
//                    carDTO.setCreatedAt(car.getCreatedAt());
//                    carDTO.setBrandId(brand.getId());
//                    carDTO.setBrandName(brand.getName());
//                    carDTO.setCategoryId(car.getCategory() != null ? car.getCategory().getId() : null);
//                    carDTO.setCategoryName(car.getCategory() != null ? car.getCategory().getName() : null);
//                    return carDTO;
//                }).collect(Collectors.toList())
//        );
//
//        return brandDTO;
//    }

    public BrandDTO findBrandWithCars(Long id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new UnsupportedMathOperationException("Marca não encontrada com o ID " + id));

        BrandDTO brandDTO = brandMapper.toDto(brand);
        brandDTO.setCars(brand.getCars().stream().map(carMapper::toDto).collect(Collectors.toList()));

        return brandDTO;
    }

}
