package com.garage.Locadora.repository;

import com.garage.Locadora.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriesRepository extends JpaRepository <Categories, Long> {
    Optional<Categories> findByName(String name);

}
