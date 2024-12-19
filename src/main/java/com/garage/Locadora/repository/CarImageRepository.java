package com.garage.Locadora.repository;

import com.garage.Locadora.entity.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarImageRepository extends JpaRepository <CarImage, Long> {
    Optional<CarImage> findByImage(String image);
}
