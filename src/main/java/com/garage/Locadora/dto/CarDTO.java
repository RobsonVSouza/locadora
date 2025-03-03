package com.garage.Locadora.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDTO {

    private Long id;

    private String name;

    private String description;

    private BigDecimal dailyRate;

    @Min(value = 1, message = "Avaliable must be at least 1")
    @Max(value = 7, message = "Avaliable cannot exceed 5")
    private int avaliable;

    private String licensePlate;

    private String color;

    private Instant createdAt;

    private Long brandId;

    private String brandName;

    private Long categoryId;

    private String categoryName;

}
