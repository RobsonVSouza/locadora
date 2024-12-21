package com.garage.Locadora.mapper;

import com.garage.Locadora.dto.CarsSpecificationDTO;
import com.garage.Locadora.entity.CarsSpecification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {})
public abstract class CarsSpecificationMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "car", ignore = true)
    @Mapping(target = "specification", ignore = true)
    public abstract CarsSpecification toEntity(CarsSpecificationDTO carsSpecificationDTO);

    @Mapping(source = "car.id", target = "carId")
    @Mapping(source = "specification.id", target = "specificationId")
    public abstract CarsSpecificationDTO toDto(CarsSpecification carsSpecification);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "car", ignore = true)
    @Mapping(target = "specification", ignore = true)
    public abstract void updateEntityFromDto(CarsSpecificationDTO specificationDTO, @MappingTarget CarsSpecification carsSpecification);
}
