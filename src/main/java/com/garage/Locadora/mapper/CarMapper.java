package com.garage.Locadora.mapper;

import com.garage.Locadora.dto.CarDTO;
import com.garage.Locadora.entity.Brand;
import com.garage.Locadora.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Mapper(componentModel = "spring", uses = {})
//@Component
public abstract class CarMapper {

   // private static final Logger logger = LoggerFactory.getLogger(CarMapper.class);

//    public CarDTO toDto(Car car){
//        if (car == null){
//            logger.warn("Tentativa de mapear um objeto nulo para CarDTO.");
//            return null;
//        }
//        CarDTO carDTO = new CarDTO();
//
//        carDTO.setId(car.getId());
//        carDTO.setName(car.getName());
//        carDTO.setDescription(car.getDescription());
//        carDTO.setDailyRate(car.getDailyRate());
//        carDTO.setAvaliable(car.getAvaliable());
//        carDTO.setLicensePlate(car.getLicensePlate());
//        carDTO.setColor(car.getColor());
//        carDTO.setCreatedAt( car.getCreatedAt());
//        carDTO.setBrandId(car.getBrand() != null ? car.getBrand().getId() : null);
//        carDTO.setCreatedAt(car.getCreatedAt() != null ? car.getCreatedAt() : Instant.now());
//        return carDTO;
//    }
//
//    public Car toEntity(CarDTO carDTO, Brand brand) {
//        if (carDTO == null) {
//            logger.warn("Tentativa de mapear um objeto nulo para Car.");
//            return null;
//        }
//        Car car = new Car();
//
//        car.setId(carDTO.getId());
//        car.setName(carDTO.getName());
//        car.setDescription(carDTO.getDescription());
//        car.setDailyRate(carDTO.getDailyRate());
//        car.setAvaliable(carDTO.getAvaliable());
//        car.setLicensePlate(carDTO.getLicensePlate());
//        car.setColor(carDTO.getColor());
//        car.setCreatedAt(carDTO.getCreatedAt() != null ? carDTO.getCreatedAt() : Instant.now());
//        car.setBrand(brand); // Setando a instância de Brand aqui
//        return car;
//    }
//
//
//    public void updateEntityFromDto(CarDTO carDTO, Car car) {
//        if (carDTO == null || car == null) {
//
//        }
//
//        car.setName(carDTO.getName());
//        car.setDescription(carDTO.getDescription());
//        car.setDailyRate(carDTO.getDailyRate());
//        car.setAvaliable(carDTO.getAvaliable());
//        car.setLicensePlate(carDTO.getLicensePlate());
//        car.setColor(carDTO.getColor());
//        car.setCreatedAt(carDTO.getCreatedAt() != null ? carDTO.getCreatedAt() : Instant.now());
//    }

    @Mapping(target = "createdAt", ignore = true)
    public abstract Car toEntity (CarDTO carDTO);

    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "categoryName")
    public abstract CarDTO toDto(Car car);

    @Mapping(target = "createdAt", ignore = true) // Ignora 'createdAt'
    @Mapping(target = "brand", ignore = true)    // Atualização manual da Brand
    @Mapping(target = "category", ignore = true) // Atualização manual da Category
    public abstract void updateEntityFromDto(CarDTO carDTO, @MappingTarget Car car);

//    public void updateEntityFromDto(CarDTO carDTO, Car car) {
//        if (carDTO == null || car == null) {
//            throw new IllegalArgumentException("CarDTO e Car não podem ser nulos.");
//        }
//
//        car.setName(carDTO.getName());
//        car.setDescription(carDTO.getDescription());
//        car.setDailyRate(carDTO.getDailyRate());
//        car.setAvaliable(carDTO.getAvaliable());
//        car.setLicensePlate(carDTO.getLicensePlate());
//        car.setColor(carDTO.getColor());
//
//        // Define 'createdAt' se necessário
//        if (carDTO.getCreatedAt() != null) {
//            car.setCreatedAt(carDTO.getCreatedAt());
//        } else {
//            car.setCreatedAt(Instant.now()); // Definindo um valor padrão
//        }
//
//        // Atualiza o 'brand' a partir do 'brandId'
//        if (carDTO.getBrandId() != null) {
//            Brand brand = new Brand(); // Aqui você pode buscar ou instanciar a Brand conforme a lógica
//            brand.setId(carDTO.getBrandId());
//            car.setBrand(brand);
//        }
//    }
}
