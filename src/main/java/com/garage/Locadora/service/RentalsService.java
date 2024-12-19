package com.garage.Locadora.service;

import com.garage.Locadora.dto.RentalsDTO;
import com.garage.Locadora.entity.Rentals;
import com.garage.Locadora.exception.UnsupportedMathOperationException;
import com.garage.Locadora.mapper.RentalsMapper;
import com.garage.Locadora.repository.RentalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalsService {

    @Autowired
    RentalsMapper rentalsMapper;

    @Autowired
    RentalsRepository rentalsRepository;


    public RentalsDTO save(RentalsDTO rentalsDTO) {
        Rentals rentals = rentalsMapper.toEntity(rentalsDTO);
        Rentals savedRentals = rentalsRepository.save(rentals);
        return rentalsMapper.toDto(savedRentals);
    }

    public List <RentalsDTO> findAll(){
        List <Rentals> rentals = rentalsRepository.findAll();
        return rentals.stream()
                .map(rentalsMapper::toDto)
                .collect(Collectors.toList());
    }

    public RentalsDTO findById(Long id){
        return rentalsRepository.findById(id)
                .map(rentalsMapper::toDto)
                .orElse(null);
    }


    public RentalsDTO update(Long id, RentalsDTO rentalsDTO) {
        Rentals existingRentals = rentalsRepository.findById(id)
                .orElseThrow(() -> new UnsupportedMathOperationException("Não existe o aluguel com o ID: " + id));
        rentalsMapper.updateEntityFromDto(rentalsDTO, existingRentals);
        Rentals updatedEntity = rentalsRepository.save(existingRentals);
        return rentalsMapper.toDto(updatedEntity);
    }

    public void delete(Long id) {
        if (!rentalsRepository.existsById(id)){
            throw new UnsupportedMathOperationException("Aluguel não existe");
        }
        rentalsRepository.deleteById(id);
    }

}
