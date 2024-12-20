package com.garage.Locadora.service;

import com.garage.Locadora.dto.RentalsDTO;
import com.garage.Locadora.dto.SpecificationDTO;
import com.garage.Locadora.entity.Specification;
import com.garage.Locadora.exception.UnsupportedMathOperationException;
import com.garage.Locadora.mapper.SpecificationMapper;
import com.garage.Locadora.repository.SpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpecificationService {

    @Autowired
    SpecificationMapper specificationMapper;

    @Autowired
    SpecificationRepository specificationRepository;

    public SpecificationDTO save(SpecificationDTO specificationDTO){
        Optional <Specification> specification = specificationRepository.findByName(specificationDTO.getName());
        if (specification.isPresent()){
            throw new UnsupportedMathOperationException("Já foi cadastrado");
        }
        return specificationMapper.toDto(specificationRepository.save(specificationMapper.toEntity(specificationDTO)));
    }

    public List <SpecificationDTO> findAll(){
        List <Specification> specifications = specificationRepository.findAll();
        return specifications.stream()
                .map(specificationMapper::toDto)
                .collect(Collectors.toList());
    }
}
