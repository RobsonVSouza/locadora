package com.garage.Locadora.mapper;

import com.garage.Locadora.dto.CarDTO;
import com.garage.Locadora.entity.Brand;
import com.garage.Locadora.entity.Car;
import com.garage.Locadora.entity.Categories;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;

@Mapper(componentModel = "spring", uses = {})
public abstract class CarMapper {

    @Mapping(target = "createdAt", ignore = true)
    public abstract Car toEntity (CarDTO carDTO);

    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "categoryName")
    public abstract CarDTO toDto(Car car);

//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "brand", expression = "java(carDTO.getBrandId() != null ? new Brand(carDTO.getBrandId()) : car.getBrand())")
//    @Mapping(target = "category", expression = "java(carDTO.getCategoryId() != null ? new Category(carDTO.getCategoryId()) : car.getCategory())")
//    public abstract void updateEntityFromDto(CarDTO carDTO, @MappingTarget Car car);

    public void updateEntityFromDto(CarDTO carDTO, Car car) {
        if (carDTO == null || car == null) {
            throw new IllegalArgumentException("CarDTO e Car não podem ser nulos.");
        }

        car.setName(carDTO.getName());
        car.setDescription(carDTO.getDescription());
        car.setDailyRate(carDTO.getDailyRate());
        car.setAvaliable(carDTO.getAvaliable());
        car.setLicensePlate(carDTO.getLicensePlate());
        car.setColor(carDTO.getColor());

        if (carDTO.getCreatedAt() != null) {
            car.setCreatedAt(carDTO.getCreatedAt());
        } else {
            car.setCreatedAt(Instant.now());
        }

        if (carDTO.getBrandId() != null) {
            Brand brand = new Brand();
            brand.setId(carDTO.getBrandId());
            car.setBrand(brand);
        } else {
            car.setBrand(null);
        }

        if (carDTO.getCategoryId() != null) {
            Categories category = new Categories();
            category.setId(carDTO.getCategoryId());
            car.setCategory(category);
        } else {
            car.setCategory(null);
        }
    }

}
