package com.garage.Locadora.repository;

import com.garage.Locadora.entity.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalsRepository extends JpaRepository <Rentals, Long> {
}
