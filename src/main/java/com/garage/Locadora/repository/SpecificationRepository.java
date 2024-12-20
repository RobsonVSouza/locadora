package com.garage.Locadora.repository;

import com.garage.Locadora.entity.Categories;
import com.garage.Locadora.entity.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecificationRepository extends JpaRepository <Specification,Long> {

    Optional<Specification> findByName(String name);
}
