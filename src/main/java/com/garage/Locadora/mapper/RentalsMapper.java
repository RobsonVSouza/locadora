package com.garage.Locadora.mapper;

import com.garage.Locadora.dto.RentalsDTO;
import com.garage.Locadora.entity.Rentals;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RentalsMapper {

    public abstract RentalsDTO toDto(Rentals rentals);

    public abstract Rentals toEntity(RentalsDTO rentalsDTO);


    public void updateEntityFromDto(RentalsDTO rentalsDTO, Rentals existingRentals) {
        if (rentalsDTO == null || existingRentals == null) {
            throw new IllegalArgumentException("DTO ou entidade não podem ser nulos.");
        }
        existingRentals.setStartDate(rentalsDTO.getStartDate());
        existingRentals.setEndtDate(rentalsDTO.getEndtDate());
        existingRentals.setTotal(rentalsDTO.getTotal());
    }
}
