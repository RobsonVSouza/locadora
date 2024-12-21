package com.garage.Locadora.repository;

import com.garage.Locadora.entity.CarsSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsSpecificationRepository  extends JpaRepository <CarsSpecification, Long> {
}
