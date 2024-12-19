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

    @Mapping(target = "createdAt", ignore = true) // Ignora o campo createdAt, pois ele é gerado automaticamente
    public abstract CarImage toEntity(CarImageDTO carImageDTO);

    @Mapping(source = "car.name", target = "carName")
    @Mapping(source = "car.id", target = "carId")
    public abstract CarImageDTO toDto(CarImage carImage);

    @Mapping(target = "createdAt", ignore = true) // Não atualiza createdAt
    @Mapping(target = "car", ignore = true)       // Atualização de car deve ser feita manualmente
    public abstract void updateEntityFromDto(CarImageDTO carImageDTO, @MappingTarget CarImage carImage);

//    private static final Logger logger = LoggerFactory.getLogger(CarMapper.class);
//
//    public CarImageDTO toDto(CarImage carImage){
//        if (carImage == null){
//            logger.warn("Tentativa de mapear um objeto nulo para CarImageDTO.");
//            return null;
//        }
//        CarImageDTO carImageDTO = new CarImageDTO();
//
//        carImageDTO.setId(carImage.getId());
//        carImageDTO.setImage(carImage.getImage());
//        carImageDTO.setCreatedAt(carImage.getCreatedAt() != null ? carImage.getCreatedAt() : Instant.now());
//        return carImageDTO;
//    }
//
//    public CarImage toEntity (CarImageDTO carImageDTO){
//        if (carImageDTO == null){
//            logger.warn("Tentativa de mapear um objeto nulo para CarImage.");
//            return null;
//        }
//        CarImage carImage = new CarImage();
//
//        carImage.setId(carImageDTO.getId());
//        carImage.setImage(carImageDTO.getImage());
//        carImage.setCreatedAt(carImageDTO.getCreatedAt() != null ? carImageDTO.getCreatedAt() : Instant.now());
//        return carImage;
//    }
//
//    public void updateEntityFromDto(CarImageDTO carImageDTO, CarImage carImage ){
//        if (carImageDTO == null || carImage == null){
//            logger.warn("Tentativa de mapear objetos nulos.");
//            return;
//        }
//
//        carImage.setImage(carImageDTO.getImage());
//        carImage.setCreatedAt(carImageDTO.getCreatedAt() != null ? carImageDTO.getCreatedAt() : Instant.now());
//    }


}
