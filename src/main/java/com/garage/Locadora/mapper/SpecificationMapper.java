package com.garage.Locadora.mapper;

import com.garage.Locadora.dto.SpecificationDTO;
import com.garage.Locadora.entity.Specification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {})
public abstract class SpecificationMapper {

    @Mapping(target = "createdAt", ignore = true)
    public abstract Specification toEntity (SpecificationDTO specificationDTO);

    public abstract SpecificationDTO toDto(Specification specification);

    @Mapping(target = "createdAt", ignore = true)
    public abstract void updateEntityFromDto(SpecificationDTO specificationDTO, @MappingTarget Specification specification);


}
