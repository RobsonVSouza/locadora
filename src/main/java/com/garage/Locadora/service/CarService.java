package com.garage.Locadora.service;

import com.garage.Locadora.dto.CarDTO;
import com.garage.Locadora.entity.Brand;
import com.garage.Locadora.entity.Car;
import com.garage.Locadora.entity.Categories;
import com.garage.Locadora.exception.UnsupportedMathOperationException;
import com.garage.Locadora.mapper.CarMapper;
import com.garage.Locadora.repository.BrandRepository;
import com.garage.Locadora.repository.CarRepository;
import com.garage.Locadora.repository.CategoriesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    CategoriesRepository categoriesRepository;

    @Autowired
    CarMapper carMapper;

//    public CarDTO save(CarDTO carDTO){
//        Optional<Car> car = carRepository.findByLicensePlate(carDTO.getLicensePlate());
//        if (car.isPresent()){
//            throw new UnsupportedMathOperationException("Já foi cadastrado");
//        }
//        return carMapper.toDto(carRepository.save(carMapper.toEntity(carDTO)));
//    }

    @Transactional
    public CarDTO save(CarDTO carDTO) {
        Optional<Car> existingCar = carRepository.findByLicensePlate(carDTO.getLicensePlate());
        if (existingCar.isPresent()) {
            throw new UnsupportedMathOperationException("Carro com esta placa já foi cadastrado!");
        }

        Brand brand = brandRepository.findById(carDTO.getBrandId())
                .orElseThrow(() -> new UnsupportedMathOperationException("Marca não encontrada com o ID: " + carDTO.getBrandId()));

        Categories categories = categoriesRepository.findById(carDTO.getCategoryId())
                .orElseThrow(() -> new UnsupportedMathOperationException("Categoria não encontrada com o ID " + carDTO.getCategoryId()));

        Car carEntity = carMapper.toEntity(carDTO);
        carEntity.setCategory(categories);
        carEntity.setBrand(brand);

        // Salva a entidade no banco
        Car savedCar = carRepository.save(carEntity);

        // Converte a entidade salva para DTO e retorna
        return carMapper.toDto(savedCar);
    }


    public List<CarDTO> findAll() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(carMapper::toDto)
                .collect(Collectors.toList());
    }

    public CarDTO findById(Long id) {
        return carRepository.findById(id)
                .map(carMapper::toDto)
                .orElse(null);
    }

//    public CarDTO update(Long id, CarDTO carDTO) {
//        Car existingCar = carRepository.findById(id)
//                .orElseThrow(() -> new UnsupportedMathOperationException("Carro não encontrado com o ID: " + id));
//
//        carRepository.findByLicensePlate(carDTO.getLicensePlate())
//                .filter(car -> !car.getId().equals(id))
//                .ifPresent(car -> {
//                    throw new UnsupportedMathOperationException("Já existe um carro com a placa: " + carDTO.getLicensePlate());
//                });
//
//        carMapper.updateEntityFromDto(carDTO, existingCar);
//
//        Car updatedCar = carRepository.save(existingCar);
//        return carMapper.toDto(updatedCar);
//    }


    public void delete(Long id) {
        if (!carRepository.existsById(id)) {
            throw new UnsupportedMathOperationException("Carro não encontrado com o ID: " + id);
        }
        carRepository.deleteById(id);
    }


}
