package com.garage.Locadora.service;

import com.garage.Locadora.dto.CustomersDTO;
import com.garage.Locadora.entity.Customers;
import com.garage.Locadora.exception.UnsupportedMathOperationException;
import com.garage.Locadora.mapper.CustomersMapper;
import com.garage.Locadora.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomersService {

    @Autowired
    CustomersRepository customersRepository;

    @Autowired
    CustomersMapper customersMapper;

    public CustomersDTO save(CustomersDTO customersDTO) {
        Optional<Customers> customers = customersRepository.findByDriverLicense(customersDTO.getDriverLicense());
        if (customers.isPresent()) {
            throw new UnsupportedMathOperationException("Já foi cadastrado");
        }
        return customersMapper.toDto(customersRepository.save(customersMapper.toEntity(customersDTO)));
    }

    public List<CustomersDTO> findAll() {
        List<Customers> customers = customersRepository.findAll();
        return customers.stream()
                .map(customersMapper::toDto)
                .collect(Collectors.toList());
    }

    public CustomersDTO findById(Long id) {
        return customersRepository.findById(id)
                .map(customersMapper::toDto)
                .orElse(null);
    }

    public CustomersDTO update(Long id, CustomersDTO customersDTO) {
        Customers existingCustomer = customersRepository.findById(id)
                .orElseThrow(() -> new UnsupportedMathOperationException("Cliente não existe"));
        customersMapper.updateEntityFromDto(customersDTO, existingCustomer);
        Customers updateCustomer = customersRepository.save(existingCustomer);
        return customersMapper.toDto(updateCustomer);
    }

    public void delete(Long id){
        if (!customersRepository.existsById(id)){
            throw new UnsupportedMathOperationException("Cliente não existe");
        }
        customersRepository.deleteById(id);
}









}
