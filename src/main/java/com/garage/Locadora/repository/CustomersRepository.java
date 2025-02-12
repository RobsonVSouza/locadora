package com.garage.Locadora.repository;

import com.garage.Locadora.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomersRepository extends JpaRepository <Customers, Long> {
    Optional<Customers> findByDriverLicense(String driverLicense);
}
