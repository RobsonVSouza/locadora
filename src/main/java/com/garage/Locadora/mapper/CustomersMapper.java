package com.garage.Locadora.mapper;

import com.garage.Locadora.dto.CustomersDTO;
import com.garage.Locadora.entity.Customers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Instant;

//@Mapper(componentModel = "spring")
@Component
public class CustomersMapper {

    private static final Logger logger = LoggerFactory.getLogger(CarMapper.class);

//    public abstract CustomersDTO toDto(Customers customers);
//
//    public abstract Customers toEntity(CustomersDTO customersDTO);
//
//    public abstract void updateEntityFromDto(CustomersDTO customersDTO, @MappingTarget Customers existingCustomer);

    public CustomersDTO toDto(Customers customers){
            if (customers == null) {
                logger.warn("Tentativa de mapear um objeto nulo para CarDTO.");
                return null;
            }
            CustomersDTO customersDTO = new CustomersDTO();

            customersDTO.setId(customers.getId());
            customersDTO.setName(customers.getName());
            customersDTO.setBirthDate(customers.getBirthDate());
            customersDTO.setEmail(customers.getEmail());
            customersDTO.setDriverLicense(customers.getDriverLicense());
            customersDTO.setAdress(customers.getAdress());
            customersDTO.setPhoneNumber(customers.getPhoneNumber());
            customersDTO.setCreatedAt(customers.getCreatedAt() != null ? customers.getCreatedAt() : Instant.now());
            customersDTO.setUpdatedAt(customers.getUpdatedAt());
            return customersDTO;
    }

    public Customers toEntity(CustomersDTO customersDTO){
        if (customersDTO == null) {
            logger.warn("Tentativa de mapear um objeto nulo para CarDTO.");
            return null;
        }
        Customers customers = new Customers();

        customers.setId(customersDTO.getId());
        customers.setName(customersDTO.getName());
        customers.setBirthDate(customersDTO.getBirthDate());
        customers.setEmail(customersDTO.getEmail());
        customers.setDriverLicense(customersDTO.getDriverLicense());
        customers.setAdress(customersDTO.getAdress());
        customers.setPhoneNumber(customersDTO.getPhoneNumber());
        customers.setCreatedAt(customersDTO.getCreatedAt() != null ? customersDTO.getCreatedAt() : Instant.now());
        customersDTO.setUpdatedAt(customersDTO.getUpdatedAt());
        return customers;
    }

    public void updateEntityFromDto(CustomersDTO customersDTO, Customers existingCustomer) {
        if (customersDTO == null || existingCustomer == null) {
            logger.warn("Tentativa de atualizar um objeto nulo.");
            return;
        }

        // Atualiza apenas os campos presentes no DTO (evita sobrescrever dados desnecessários)
        if (customersDTO.getName() != null) {
            existingCustomer.setName(customersDTO.getName());
        }
        if (customersDTO.getBirthDate() != null) {
            existingCustomer.setBirthDate(customersDTO.getBirthDate());
        }
        if (customersDTO.getEmail() != null) {
            existingCustomer.setEmail(customersDTO.getEmail());
        }
        if (customersDTO.getDriverLicense() != null) {
            existingCustomer.setDriverLicense(customersDTO.getDriverLicense());
        }
        if (customersDTO.getAdress() != null) {
            existingCustomer.setAdress(customersDTO.getAdress());
        }
        if (customersDTO.getPhoneNumber() != null) {
            existingCustomer.setPhoneNumber(customersDTO.getPhoneNumber());
        }

        existingCustomer.setUpdatedAt(Instant.now());
    }

}
