package com.garage.Locadora.mapper;

import com.garage.Locadora.dto.CarImageDTO;
import com.garage.Locadora.entity.CarImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = {})
public abstract class CarImageMapper {

    @Mapping(target = "createdAt", ignore = true)
    public abstract CarImage toEntity(CarImageDTO carImageDTO);

    @Mapping(source = "car.name", target = "carName")
    @Mapping(source = "car.id", target = "carId")
    public abstract CarImageDTO toDto(CarImage carImage);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "car", ignore = true)
    public abstract void updateEntityFromDto(CarImageDTO carImageDTO, @MappingTarget CarImage carImage);

}
