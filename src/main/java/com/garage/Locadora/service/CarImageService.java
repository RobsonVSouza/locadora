package com.garage.Locadora.service;

import com.garage.Locadora.dto.CarImageDTO;
import com.garage.Locadora.entity.Car;
import com.garage.Locadora.entity.CarImage;
import com.garage.Locadora.exception.UnsupportedMathOperationException;
import com.garage.Locadora.mapper.CarImageMapper;
import com.garage.Locadora.repository.CarImageRepository;
import com.garage.Locadora.repository.CarRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarImageService {

    @Autowired
    CarImageRepository carImageRepository;

    @Autowired
    CarImageMapper carImageMapper;

    @Autowired
    CarRepository carRepository;

    @Transactional
    public CarImageDTO save(CarImageDTO carImageDTO){
        Optional <CarImage> carImage = carImageRepository.findByImage(carImageDTO.getImage());
        if (carImage.isPresent()){
            throw new UnsupportedMathOperationException("Já foi cadastrado");
        }

        Car car = carRepository.findById(carImageDTO.getCarId())
                .orElseThrow(() -> new UnsupportedMathOperationException("Carro não encontrado"));

        CarImage carEntity = carImageMapper.toEntity(carImageDTO);
        carEntity.setCar(car);

        CarImage savedImage = carImageRepository.save(carEntity);

        //return carImageMapper.toDto(carImageRepository.save(carImageMapper.toEntity(carImageDTO)));
        return carImageMapper.toDto(savedImage);
    }

    public List <CarImageDTO> findAll(){
        List <CarImage> carImages = carImageRepository.findAll();
        return carImages.stream()
                .map(carImageMapper::toDto)
                .collect(Collectors.toList());
    }

    public CarImageDTO findById(Long id){
        return carImageRepository.findById(id)
                .map(carImageMapper::toDto)
                .orElse(null);
    }

    public CarImageDTO update (Long id, CarImageDTO carImageDTO){
        CarImage existingCarImage = carImageRepository.findById(id)
                .orElseThrow(() -> new UnsupportedMathOperationException("Imagem não encontrada"));
        carImageMapper.updateEntityFromDto(carImageDTO, existingCarImage);
        CarImage updateCarImage = carImageRepository.save(existingCarImage);
        return carImageMapper.toDto(updateCarImage);
    }

    public void delete(Long id){
        if (!carImageRepository.existsById(id)){
            throw new UnsupportedMathOperationException("Imagem não encontrada");
        }
        carImageRepository.deleteById(id);
    }

}
